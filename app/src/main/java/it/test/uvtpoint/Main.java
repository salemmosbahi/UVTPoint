package it.test.uvtpoint;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends AppCompatActivity {
    private EditText etxtUsername;
    private EditText etxtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        etxtUsername = (EditText) findViewById(R.id.etxtUsername);
        etxtPassword = (EditText) findViewById(R.id.etxtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ("hello".equals(etxtUsername.getText().toString().toLowerCase()) &&
                        "hello".equals(etxtPassword.getText().toString().toLowerCase())) {
                    Intent list = new Intent(Main.this, UVTList.class);
                    startActivity(list);
                    finish();
                } else
                    Toast.makeText(getApplicationContext(), "your name or password invalid",
                            Toast.LENGTH_LONG).show();
            }
        });
    }
}
