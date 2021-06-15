package lg.gm.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    LinearLayout SignUpBtnFinal;
    private FirebaseAuth mAuth;

    EditText emailedt,passedt,username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        SignUpBtnFinal=findViewById(R.id.signUpbtnFinal);

        mAuth = FirebaseAuth.getInstance();


        emailedt=findViewById(R.id.emailEdt);
        username=findViewById(R.id.user_name);
        passedt=findViewById(R.id.passEdt);

        SignUpBtnFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=emailedt.getText().toString();
                String pass=passedt.getText().toString();
                String name=username.getText().toString();


                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {       FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(name).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Intent intent=new Intent(SignUpActivity.this,Dashbord.class);
                                            startActivity(intent);
                                        } else {
                                            //display a failure message
                                            Log.e("error","error");
                                        }
                                    }
                                });
                        }
                        else {

                            Toast.makeText(SignUpActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}