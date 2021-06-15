package lg.gm.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText edtemail,edtpass;
    LinearLayout login,signup;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtemail=findViewById(R.id.edtEmail);
        edtpass=findViewById(R.id.edtPass);

        mAuth = FirebaseAuth.getInstance();

        login=findViewById(R.id.lopginLoginBtn);
        signup=findViewById(R.id.loginSignupBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=edtemail.getText().toString();
                String pass=edtpass.getText().toString();

                mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Intent intent=new Intent(LoginActivity.this,Dashbord.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Error...", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}