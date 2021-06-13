package lg.gm.inventory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Dashbord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);
    }

    public void movetoadd(View view) {
        Intent intent = new Intent(Dashbord.this, Add_data.class);
        startActivity(intent);
    }

    public void movetoview(View view) {
        Intent intent = new Intent(Dashbord.this, View_data.class);
        startActivity(intent);
    }

    public void signout(View view) {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(Dashbord.this,LoginActivity.class);
        startActivity(intent);

    }
}