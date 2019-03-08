package qianxing.taojinke.ui.test;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import qianxing.taojinke.R;
import taojinke.qianxing.lib_kernel.sharedpreference.SharedPreferenceUtils;

public class TestSettingActivity extends AppCompatActivity {


    @BindView(R.id.test_switch)
    EditText testSwitch;
    @BindView(R.id.test)
    CheckBox test;
    @BindView(R.id.pre_online)
    CheckBox preOnline;
    @BindView(R.id.on_line)
    CheckBox onLine;
    @BindView(R.id.cl_content)
    ConstraintLayout clContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_setting);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {

        if (SharedPreferenceUtils.isTestEnvironment(this)) {
            if (SharedPreferenceUtils.isPreOnLineEnvironment(this)) {
                preOnline.setChecked(true);
            } else {
                test.setChecked(true);
            }
        } else {
            onLine.setChecked(true);
        }

        testSwitch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(s)) {
                    if ("liuhaijian".equalsIgnoreCase(s.toString())
                            || "tangwenhui".equalsIgnoreCase(s.toString())) {
                        clContent.setVisibility(View.VISIBLE);
                    } else {
                        clContent.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        test.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    clearLocalFile();
                    preOnline.setChecked(false);
                    onLine.setChecked(false);
                    SharedPreferenceUtils.setTestEnvironment(TestSettingActivity.this, true);
                    SharedPreferenceUtils.setPreOnLineEnvironment(TestSettingActivity.this, false);
                }
            }
        });

        preOnline.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    clearLocalFile();
                    test.setChecked(false);
                    onLine.setChecked(false);
                    SharedPreferenceUtils.setTestEnvironment(TestSettingActivity.this, true);
                    SharedPreferenceUtils.setPreOnLineEnvironment(TestSettingActivity.this, true);
                }
            }
        });

        onLine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    clearLocalFile();
                    test.setChecked(false);
                    preOnline.setChecked(false);
                    SharedPreferenceUtils.setTestEnvironment(TestSettingActivity.this, false);
                    SharedPreferenceUtils.setPreOnLineEnvironment(TestSettingActivity.this, false);
                }
            }
        });


    }

    private void clearLocalFile() {
        SharedPreferenceUtils.clearPreference(this, "Token");
        SharedPreferenceUtils.clearVoipPerference(this);
        SharedPreferenceUtils.clearVoipPwdPerference(this);
        SharedPreferenceUtils.clearUserIDPerference(this);
        SharedPreferenceUtils.clearUserNamePreference(this);
        SharedPreferenceUtils.clearHeadPreference(this);
        SharedPreferenceUtils.clearPhonePreference(this);
        SharedPreferenceUtils.clearpaymentAccountIdPerference(this);
        SharedPreferenceUtils.clearHadIMlogin(this);
        SharedPreferenceUtils.clearImFilePerference(this);
        //删除视频记录时长
        SharedPreferenceUtils.clearTrainVideoTime(this);

        SharedPreferenceUtils.clearGuideStatus(this);
        SharedPreferenceUtils.clearTrainPageTime(this);
        SharedPreferenceUtils.clearExam(this);
    }


}
