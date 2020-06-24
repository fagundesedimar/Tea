package tcc.com.br.tea.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import tcc.com.br.tea.R;

public class AberturaActivity extends AppCompatActivity implements  Runnable {

    public static final String TITULO_APPBAR = "SEJA BEM VINDO  : )";

    private ProgressBar progressBar;
    private  Thread thread;
    private Handler handler;
    private  int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abertura);

        setTitle(TITULO_APPBAR);

        progressBar = (ProgressBar) findViewById(R.id.progresBar_abertura);


        handler = new Handler();
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {
        i = 1;
        try {
            while (i <= 100) {

                Thread.sleep(50);
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        i++;
                        progressBar.setProgress(i);

                    }
                });
            }
            finish();
            startActivity(new Intent(getBaseContext(), EscolhaSouUmActivity.class));

        } catch (InterruptedException e) {

        }
    }



}
