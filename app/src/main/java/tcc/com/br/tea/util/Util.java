package tcc.com.br.tea.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.widget.Toast;

public class Util {

    public static void opçoesErroFirebase(Context context, String resposta) {
        if (resposta.contains("least 6 characters")){
            Toast.makeText(context,"Erro - Senha deve ter no minimo 6 caracteres!",Toast.LENGTH_LONG).show();
        } else if (resposta.contains("address is badly")) {
            Toast.makeText(context,"Erro - E-mail Invalido!",Toast.LENGTH_LONG).show();
        } else if (resposta.contains("interrupted connection")) {
            Toast.makeText(context,"Erro - Sem conexão com Firebase, (Banco de Dados)!",Toast.LENGTH_LONG).show();
        } else if (resposta.contains("password is invalid")) {
            Toast.makeText(context,"Erro - Senha Invalida!",Toast.LENGTH_LONG).show();
        } else if (resposta.contains("There is no user")) {
            Toast.makeText(context,"Erro - E-mail não Cadastrado!",Toast.LENGTH_LONG).show();
        } else if (resposta.contains("address is already")) {
            Toast.makeText(context,"Erro - E-mail já existe Cadastrado!",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context,resposta,Toast.LENGTH_LONG).show();
        }
    }

    public static boolean statusInternet_MoWi(Context context) {
        boolean status = false;
        ConnectivityManager conexao = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (conexao != null){
            // PARA DISPOSTIVOS NOVOS
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                NetworkCapabilities recursosRede = conexao.getNetworkCapabilities(conexao.getActiveNetwork());
                if (recursosRede != null) {//VERIFICAMOS SE RECUPERAMOS ALGO
                    if (recursosRede.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) { //VERIFICAMOS SE DISPOSITIVO TEM 3G
                        return true;
                    }
                    else if (recursosRede.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        //VERIFICAMOS SE DISPOSITIVO TEM WIFFI
                        return true;
                    }
                    //NÃO POSSUI UMA CONEXAO DE REDE VÁLIDA
                    return false;
                }
            } else {//COMECO DO ELSE
                // PARA DISPOSTIVOS ANTIGOS  (PRECAUÇÃO)
                NetworkInfo informacao = conexao.getActiveNetworkInfo();
                if (informacao != null && informacao.isConnected()) {
                    status = true;
                } else
                    status = false;
                return status;
            }//FIM DO ELSE
        }
        return false;
    }


}
