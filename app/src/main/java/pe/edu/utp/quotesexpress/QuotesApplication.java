package pe.edu.utp.quotesexpress;

import android.app.Application;

import pe.edu.utp.quotesexpress.models.QuotesService;

/**
 * Created by GrupoUTP on 01/10/2016.
 */

public class QuotesApplication extends Application {
    private QuotesService service;

    public QuotesService getService() {
        if(service==null) service  = new QuotesService();
        return service;
    }


}
