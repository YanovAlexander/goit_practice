package com.goit.practice.http.practice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;

public class YoutubeClient {
    private static final OkHttpClient CLIENT = new OkHttpClient();
    private static final String ROOT_URL = "https://www.googleapis.com";
    private static ObjectMapper mapper = new ObjectMapper();
    public static void main(String[] args) {
        HttpUrl url = HttpUrl.parse(ROOT_URL).newBuilder()
                .addPathSegment("youtube")
                .addPathSegment("v3")
                .addPathSegment("search")
                .addQueryParameter("part", "snippet")
                .addQueryParameter("channelId", "UCo_q6aOlvPH7M-j_XGWVgXg")
                .addQueryParameter("maxResults", "10")
                .addQueryParameter("oder", "date")
                .addQueryParameter("type", "video")
                .addQueryParameter("key", "AIzaSyCGb80YiFrBGofQ3eB_Q_CDoC6B0lnG1n8")
                .build();

        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = CLIENT.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("Some error has occurred " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                YoutubeChannelList youtubeChannelList = mapper.readValue(response.body().bytes(), new TypeReference<YoutubeChannelList>() {});
                System.out.println();
            }
        });
    }
}
