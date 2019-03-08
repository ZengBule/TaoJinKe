/*
 * Copyright © Yan Zhenjie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package qianxing.taojinke.ui.launcher;

import android.content.Context;
import android.content.DialogInterface;

import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;

import java.util.List;

import androidx.appcompat.app.AlertDialog;


/**
 * Created by YanZhenjie on 2018/1/1.
 */
public final class DefaultRationale implements Rationale {

    @Override
    public void showRationale(Context context, List<String> permissions, final RequestExecutor executor) {
        List<String> permissionNames = Permission.transformText(context, permissions);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < permissionNames.size(); i++) {
            sb.append(permissionNames.get(i));
            if (i != permissionNames.size() - 1) {
                sb.append("\n");
            }
        }
        //master_test
        new AlertDialog.Builder(context)
                .setCancelable(false)
                .setMessage("继续正常使用需要授予如下权限：\n"+sb.toString())
                .setPositiveButton("继续", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        executor.execute();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        executor.cancel();
                    }
                })
                .show();
    }
}