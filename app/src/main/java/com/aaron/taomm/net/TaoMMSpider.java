package com.aaron.taomm.net;

import android.os.AsyncTask;

import com.aaron.taomm.util.LogUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by Aaron on 15/7/3.
 */
public class TaoMMSpider {

    private static final String TAG = TaoMMSpider.class.getSimpleName();

    public static void start() {
        new FetchContentTask().execute();
    }

    static class FetchContentTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                Document doc = Jsoup.connect("http://mm.taobao.com/json/request_top_list.htm?type=0&page=1")
                        .userAgent("Mozilla")
                        .timeout(3000)
                        .get();
                String content = doc.outerHtml();
                LogUtil.i(TAG, "html: " + content);

                Elements links = doc.select("a[href]");
                for (Element link : links) {
                    String linkHref = link.attr("href");
                    String linkText = link.text();

                    Pattern pattern = Pattern.compile("//mm.taobao.com/");

                    LogUtil.d(TAG, "linkHref: " + linkHref + "; linkText: " + linkText);
                }

                return content;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }

}
