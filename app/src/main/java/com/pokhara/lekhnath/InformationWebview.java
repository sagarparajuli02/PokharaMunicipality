package com.pokhara.lekhnath;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class InformationWebview extends Fragment {

    ProgressBar progressBar;
    WebView webView;

    public InformationWebview() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_information_webview, container, false);


        progressBar= (ProgressBar) view.findViewById(R.id.progressbar) ;
        webView= (WebView) view.findViewById(R.id.webview);
        webView.setVisibility(View.INVISIBLE);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public  void onPageStarted (WebView view, String url , Bitmap favicon){
                super.onPageStarted(view, url, favicon);
            }
            @Override
            public  void  onPageFinished(WebView view, String url){
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
            }
        });

        webView.loadUrl("http://pokharalekhnathmun.gov.np/news-notices");

        return  view;
    }

}
