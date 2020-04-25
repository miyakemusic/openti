package openti;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

public class OkHttp3CookieHelper {

    private final Map<String, List<Cookie>> mServerCookieStore = new ConcurrentHashMap<String, List<Cookie>>();

    private Map<String, List<Cookie>> mClientCookieStore = new ConcurrentHashMap<String, List<Cookie>>();

    private final CookieJar mCookieJar = new CookieJar() {
        @Override
        public List<Cookie> loadForRequest(HttpUrl url) {

            List<Cookie> serverCookieList = mServerCookieStore.get(url.host());

            if (serverCookieList == null) {
                serverCookieList = new ArrayList<Cookie>();
            }

            final List<Cookie> clientCookieStore = mClientCookieStore.get(url.host());

            if (clientCookieStore != null) {
                serverCookieList.addAll(clientCookieStore);
            }

            return serverCookieList != null ? serverCookieList : new ArrayList<Cookie>();
        }

        @Override
        public void saveFromResponse(HttpUrl url, List<Cookie> unmodifiableCookieList) {
            mServerCookieStore.put(url.host(), new ArrayList<Cookie>(unmodifiableCookieList));
        }

    };

    public void setCookie(String url, Cookie cookie) {

        final String host = HttpUrl.parse(url).host();

        List<Cookie> cookieListForUrl = mClientCookieStore.get(host);
        if (cookieListForUrl == null) {
            cookieListForUrl = new ArrayList<Cookie>();
            mClientCookieStore.put(host, cookieListForUrl);
        }
        putCookie(cookieListForUrl, cookie);

    }

    public void setCookie(String url, String key, String value) {
        final HttpUrl httpUrl = HttpUrl.parse(url);
        setCookie(url, Cookie.parse(httpUrl, key + "=" + value));
    }

    public void setCookie(HttpUrl httpUrl, String key, String value) {
        setCookie(httpUrl.host(), Cookie.parse(httpUrl, key + "=" + value));
    }

    public CookieJar cookieJar() {
        return mCookieJar;
    }

    private void putCookie(List<Cookie> storedCookieList, Cookie newCookie) {

        Cookie oldCookie = null;
        for (Cookie storedCookie : storedCookieList) {

            // create key for comparison
            final String oldCookieKey = storedCookie.name() + storedCookie.path();
            final String newCookieKey = newCookie.name() + newCookie.path();

            if (oldCookieKey.equals(newCookieKey)) {
                oldCookie = storedCookie;
                break;
            }
        }
        if (oldCookie != null) {
            storedCookieList.remove(oldCookie);
        }
        storedCookieList.add(newCookie);
    }

}
