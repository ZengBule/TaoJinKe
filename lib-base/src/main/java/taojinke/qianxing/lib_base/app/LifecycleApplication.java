package taojinke.qianxing.lib_base.app;


import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import taojinke.qianxing.lib_base.app.dagger.component.DaggerGlobalComponent;
import taojinke.qianxing.lib_base.app.dagger.component.GlobalComponent;
import taojinke.qianxing.lib_base.app.dagger.module.ApplicationModule;
import taojinke.qianxing.lib_base.utils.Check;
import taojinke.qianxing.lib_weight.loading.DefaultStatusViewCreator;
import taojinke.qianxing.lib_weight.loading.LoadingHelperViewCreator;

public class LifecycleApplication extends Application {

    private GlobalComponent globalComponent;
    private Map<String, ApplicationLike> lifecycleMap = new HashMap<>();

    @Override
    public void onCreate() {
        super.onCreate();
        LoadingHelperViewCreator.setDefaultStatusViewCreator(new DefaultStatusViewCreator());
        ARouter.openLog();
        //线上需关闭 调试时可用，否则不能使用Instant run
        ARouter.openDebug();
        ARouter.init(this);

        globalComponent = DaggerGlobalComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        registerCallbacks(getActivityLifecycleCallbacks());
        loadProjectApplicationLike();
    }

    private void registerCallbacks(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }


    protected ActivityLifecycleCallbacks getActivityLifecycleCallbacks() {
        return new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                ActivityManager.getInstance().push(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                ActivityManager.getInstance().remove(activity);
            }
        };
    }

    private void loadProjectApplicationLike() {
        ApplicationLike[] allApplicationLikes = getAllApplicationLikes();
        ApplicationLike[] objectsWithInterface;
        if (Check.isEmpty(allApplicationLikes)) {
            objectsWithInterface = fetchAllApplicationLike();
        } else {
            objectsWithInterface = allApplicationLikes;
        }

        for (ApplicationLike applicationLike : objectsWithInterface) {
            register(applicationLike);
        }
    }

    protected ApplicationLike[] getAllApplicationLikes() {
        return fetchAllApplicationLike();
    }

    private ApplicationLike[] fetchAllApplicationLike() {
        List<ApplicationLike> applicationLikes = new ArrayList<>();

//        BufferedReader reader = null;
//        try {
//            InputStream open = getAssets().open("library.json");
//            reader = new BufferedReader(new InputStreamReader(open));
//            StringBuilder builder = new StringBuilder();
//            String temp;
//            while ((temp = reader.readLine()) != null) {
//                builder.append(temp);
//            }
//
//            JSONObject object = JSON.parseObject(builder.toString());
//
//            List<ModuleVersion> library = JSON.parseArray(object.getString("library"), ModuleVersion.class);
//            for (ModuleVersion mv :
//                    library) {
//                ApplicationLike like = (ApplicationLike) ARouter.getInstance().build(mv.getPath()).navigation();
//                if (like != null) {
//                    applicationLikes.add(like);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        return applicationLikes.toArray(new ApplicationLike[applicationLikes.size()]);
    }

    private void register(ApplicationLike applicationLike) {
        if (applicationLike == null) {
            throw new IllegalArgumentException("application must not be null");
        }

        String canonicalName = applicationLike.getClass().getCanonicalName();

        lifecycleMap.put(canonicalName, applicationLike);
    }

    public GlobalComponent getGlobalComponent() {
        return globalComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (!Check.isEmpty(lifecycleMap)) {
            for (String name : lifecycleMap.keySet()) {
                lifecycleMap.get(name)
                        .onTerminate();
            }
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (!Check.isEmpty(lifecycleMap)) {
            for (String name : lifecycleMap.keySet()) {
                lifecycleMap.get(name)
                        .onLowMemory();
            }
        }
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (!Check.isEmpty(lifecycleMap)) {
            for (String name : lifecycleMap.keySet()) {
                lifecycleMap.get(name)
                        .onTrimMemory(level);
            }
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        if (!Check.isEmpty(lifecycleMap)) {
            for (String name : lifecycleMap.keySet()) {
                lifecycleMap.get(name)
                        .attachBaseContext(base);
            }
        }
    }

    public <T extends ApplicationLike> T fetchApplicationLike(Class<T> aClass) {
        if (aClass == null) {
            return null;
        }
        String className = aClass.getCanonicalName();
        return (T) lifecycleMap.get(className);
    }

    protected void clearLikes() {
        lifecycleMap.clear();
    }
}
