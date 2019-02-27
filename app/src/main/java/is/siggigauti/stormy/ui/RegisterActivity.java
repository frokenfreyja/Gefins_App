package is.siggigauti.stormy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import is.siggigauti.stormy.R;

public class RegisterActivity extends AppCompatActivity {

    //Skilgreiningar
    private Button registerBtn;

    private EditText emailEdTxt;
    private EditText passEdTxt;
    private EditText confirmEdTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailEdTxt = findViewById(R.id.registerEmailEditText);
        passEdTxt = findViewById(R.id.registerPassEditText);
        confirmEdTxt = findViewById(R.id.registerPassConfEditText);

        registerBtn = findViewById(R.id.registerButton);

        // Virkni á RegisterTakkanum
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                // Nær í textan frá input field sem eru á register skjá
                // aka tölvupóstinn, lykillorðið og endurtekninguna
                String email = emailEdTxt.getText().toString();
                String password = passEdTxt.getText().toString();
                String passwordConfirm = confirmEdTxt.getText().toString();

                if (password.equals(passwordConfirm)) {

                    //Fer frá Registerskjá á Login skjá
                    Intent intent = new Intent(RegisterActivity.this, UserActivity.class);
                    startActivity(intent);
                } else {

                    //Varar við að Lykilorð eru mismunandi
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    builder.setMessage("Mismundandi lykilorð")
                            .setNegativeButton("Reyna Aftur", null)
                            .create()
                            .show();
                }
            }
        });

    }
}