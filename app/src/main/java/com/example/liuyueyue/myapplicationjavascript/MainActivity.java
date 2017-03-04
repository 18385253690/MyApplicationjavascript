package com.example.liuyueyue.myapplicationjavascript;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private WebView contentWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentWebView = (WebView) findViewById(R.id.webview);
        contentWebView.getSettings().setJavaScriptEnabled(true);
        contentWebView.loadUrl("file:///android_asset/web.html");
        contentWebView.addJavascriptInterface(MainActivity.this,"android");

      findViewById(R.id.button).setOnClickListener(new
              View.OnClickListener(){
            public void onClick(View v){
                contentWebView.loadUrl("javascript:javacalljs()");

            }
        });
findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        contentWebView.loadUrl("javascript:javacalljswith("+"'1513157252'"+")");

    }
});
    }
    @JavascriptInterface

    public void startFunction(){
      runOnUiThread(new Runnable() {
          @Override
          public void run() {
              Toast.makeText(MainActivity.this,"show",Toast.LENGTH_SHORT).show();
          }
      });
    }
    @JavascriptInterface
    public void startFunction(final String text){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(MainActivity.this).setMessage(text).show();

            }
        });
    }
}
