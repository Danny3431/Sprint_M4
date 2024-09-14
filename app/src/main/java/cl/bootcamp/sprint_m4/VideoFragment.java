package cl.bootcamp.sprint_m4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebResourceRequest;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;

import cl.bootcamp.sprint_m4.databinding.ActivityVideoFragmentBinding;


public class VideoFragment extends Fragment {
    private ActivityVideoFragmentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = ActivityVideoFragmentBinding.inflate(inflater, container, false);

        // Configura el WebView para mostrar el video de YouTube
        WebView webView = binding.webview;
        webView.getSettings().setJavaScriptEnabled(true); // Habilita JavaScript

        webView.setWebViewClient(new WebViewClient() { // Crear una instancia anónima de WebViewClient
            @Override
            public boolean shouldOverrideUrlLoading(WebView web, WebResourceRequest request) {
                return false; // Permite la carga de la URL en el WebView
            }
        });

        webView.loadUrl("https://www.youtube.com/watch?v=68Pto3HwLRI"); // URL del video

        return binding.getRoot();
    }
}