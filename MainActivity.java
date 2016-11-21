import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        LoadPage();
    }
    public Button Btn;
    public void LoadPage(){
        Btn = (Button)findViewById(R.id.LoginBtn);
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebPage.class);
                final EditText username = (EditText) findViewById(R.id.LoginTx);
                intent.putExtra("Username", username.getText().toString());
                final EditText password = (EditText) findViewById(R.id.PasswordTx);
                intent.putExtra("Password", password.getText().toString());
                startActivity(intent);
            }
        });
    }
