package com.ben.android.recyclerview;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {
    public static List<New> getNews() {
        List<New> news = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            news.add(new New("NewItem" + i, "NewDesc" + i, 0));
        }
        return news;
    }
}
