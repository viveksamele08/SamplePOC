package geeksforandroidgeeks.com.spapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class CCCWebView extends AppCompatActivity {

    WebView webview;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cccweb_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mProgressBar = (ProgressBar) findViewById(R.id.pb);
        mProgressBar.setVisibility(View.VISIBLE);
        webview = (WebView) findViewById(R.id.webView);
        webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int newProgress)
            {
                //Make the bar disappear after URL is loaded, and changes string to Loading...
                mProgressBar.setProgress(newProgress);
                if(newProgress == 100){
                    // Hide the progressbar
                    mProgressBar.setVisibility(View.GONE);
                }
            }
        });
        webview.setWebViewClient(new MyBrowser());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("https://sso.sp.edu.sg/login");

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
