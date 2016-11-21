import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebPage extends AppCompatActivity {
    static WebView mWebView;
    class MyAsyncTask extends AsyncTask
    {
        @Override
        protected Object doInBackground(Object[] params) {
            return null;
        }

        private Context context;
        public MyAsyncTask(Context context) {
            this.context = context;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            try {
                final String user = getIntent().getExtras().getString("Username");
                final String pwd = getIntent().getExtras().getString("Password");
                setContentView(R.layout.activity_web_page);
                mWebView = (WebView) findViewById(R.id.webView2);
                String url1 = "http://www.webnotes.cz/";
                mWebView.getSettings().setJavaScriptEnabled(true);
                mWebView.getSettings().setDomStorageEnabled(true);
                CookieManager.getInstance().setAcceptCookie(true);
                mWebView.getSettings().setSaveFormData(true);
                mWebView.loadUrl(url1);
                mWebView.setWebViewClient(new WebViewClient() {
                    public void onPageFinished(WebView view, String url) {
                        view.loadUrl("javascript:document.getElementById('UID0').value = '"+user+"';document.getElementById('PASS0').value='"+pwd+"';javascript:document.getElementById('butLogon').click();");
                    }
                });
                //SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy%20hh:mm:ss");
                //final String date = sdf.format(new Date());
                //mWebView.loadUrl("http://www.webnotes.cz/Distrib_v.asp?ET='"+date+"'");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_web_page);
        MyAsyncTask myTask = new MyAsyncTask(this);
        myTask.execute();
    }

    }
