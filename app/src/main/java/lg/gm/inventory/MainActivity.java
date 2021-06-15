package lg.gm.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    LinearLayout login,signup;
    private FirebaseAuth mAuth;
    private Intent Dashbord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login=findViewById(R.id.mainLoginBtn);
        signup=findViewById(R.id.mainSignUpBtn);
        Dashbord = new Intent(this,lg.gm.inventory.Dashbord.class);


        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
    private void updateUI() {

        startActivity(Dashbord);
        finish();

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();

        if(user != null) {
            //user is already connected  so we need to redirect him to home page
            updateUI();

        }
        else {
            startActivity(new Intent(this,LoginActivity.class));
            finish();

        }


    }
}