package com.singtel.espresso.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.text.Editable;
import static android.view.KeyEvent.ACTION_DOWN;
import static android.view.KeyEvent.KEYCODE_ENTER;
import static android.view.inputmethod.EditorInfo.IME_ACTION_DONE;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockActivity;
import com.singtel.espresso.R;
import com.singtel.espresso.core.*;
import com.singtel.espresso.utils.*;
import com.singtel.espresso.utils.SafeAsyncTask;
import com.singtel.espresso.utils.DomainEnum;

import static com.github.kevinsawicki.http.HttpRequest.get;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-9-3
 * Time: 下午2:13
 * To change this template use File | Settings | File Templates.
 */
public class Login extends SherlockActivity {
    CustomCredential customCredential = new CustomCredential();
    User user = new User();
    private SafeAsyncTask<Boolean> authenticationTask;

    public static final String PARAM_USERNAME = "UserName";
    public static final String PARAM_PASSWORD = "Password";
    public static final String PARAM_ISPERSISTENT = "isPersistent";
    public static final String PARAM_CUSTOMCREDENTIAL = "customCredential";

    View singtelBtnView;
    View ncsBtnView;
    View optusBtnView;
    Button loginButton;

    EditText passwordEditText;
    EditText loginUserText;

    private TextWatcher watcher = validationTextWatcher();



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        setCustomCredential(customCredential);

//        Button loginButton = (Button)findViewById(R.id.LoginButton);
//        loginButton.setOnClickListener(clickLogin);

        singtelBtnView = (View) findViewById(R.id.singtelBtn);
        ncsBtnView = (View)findViewById(R.id.ncsBtn);
        optusBtnView = (View)findViewById(R.id.optusBtn);

        TextView domainTextView = (TextView)findViewById(R.id.domainTextView);
        TextView PasswordTextView = (TextView)findViewById(R.id.passwordTextView);

        Typeface font=Typeface.createFromAsset(getAssets(),"fonts/Roboto-Regular.ttf");

        domainTextView.setTypeface(font);
        PasswordTextView.setTypeface(font);

        loginUserText = (EditText)findViewById(R.id.domainTextID);
        passwordEditText = (EditText)findViewById(R.id.passwrodTextID);

        loginUserText.addTextChangedListener(watcher);
        passwordEditText.addTextChangedListener(watcher);

        loginButton = (Button) findViewById(R.id.loginBtn);


        passwordEditText.setOnKeyListener(new View.OnKeyListener(){

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event != null && ACTION_DOWN == event.getAction()
                        && keyCode == KEYCODE_ENTER && loginButton.isEnabled()) {
                    handleLogin(loginButton);
                    return true;
                }
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == IME_ACTION_DONE && loginButton.isEnabled()) {
                    handleLogin(loginButton);
                    return true;
                }
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }

    private TextWatcher validationTextWatcher(){
        return new TextWatcherAdapter() {
            public void afterTextChanged(Editable gitDirEditText) {
                updateUIWithValidation();
            }

        };
    }

    private void updateUIWithValidation(){
        boolean valueAvailable = checkText(loginUserText) && checkText(passwordEditText);
        loginButton.setEnabled(valueAvailable);
    }

    public boolean checkText(EditText v){
        return v.length()>0;
    }

    public void handleLogin(View v){
        if(!loginButton.isEnabled())
            return;
    }

    public void singtelBtnClick(View v){
            v.setBackgroundResource(R.drawable.singtel_click);
            ncsBtnView.setBackgroundResource(R.drawable.ncs_unclick);
            optusBtnView.setBackgroundResource(R.drawable.optus_unclick);
            user.setDomain(DomainEnum.SINGTEL.toString());
    }

    public void ncsBtnClick(View v){
            v.setBackgroundResource(R.drawable.ncs_click);
            singtelBtnView.setBackgroundResource(R.drawable.singtel_unclick);
            optusBtnView.setBackgroundResource(R.drawable.optus_unclick);
            user.setDomain(DomainEnum.NCS.toString());
    }

    public void optusBtnClick(View v){
            v.setBackgroundResource(R.drawable.optus_click);
            singtelBtnView.setBackgroundResource(R.drawable.singtel_unclick);
            ncsBtnView.setBackgroundResource(R.drawable.ncs_unclick);
            user.setDomain(DomainEnum.OPTUS.toString());
    }

    private void setCustomCredential(CustomCredential customCredential){
        customCredential.setAppID("com.singtel.espresso");
        customCredential.setApplicationVersion(Utils.getVersion(this));
    }

    /**
     * Hide progress dialog
     */
    @SuppressWarnings("deprecation")
    protected void hideProgress() {
        dismissDialog(0);
    }

    /**
     * Show progress dialog
     */
    @SuppressWarnings("deprecation")
    protected void showProgress() {
        showDialog(0);
    }
}