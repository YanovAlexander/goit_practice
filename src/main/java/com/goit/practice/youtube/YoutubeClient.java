package com.goit.practice.youtube;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goit.practice.youtube.model.YoutubeChannelList;
import okhttp3.*;

import java.io.IOException;
import java.util.Objects;

public class YoutubeClient {
    private static final String ROOT_URL = "https://www.googleapis.com";
    private static ObjectMapper mapper = new ObjectMapper();
    private static final OkHttpClient CLIENT = new OkHttpClient.Builder().build();

    public static void main(String[] args) {
        Request request = new Request.Builder()
                .get()
                .url(prepareHttpUrl())
                .build();

        Call call = CLIENT.newCall(request);

        //Async call to youtube api
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("Some error has occurred " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                YoutubeChannelList youtubeChannelList = mapper.readValue(Objects.requireNonNull(response.body()).bytes(),
                        YoutubeChannelList.class);
                youtubeChannelList.getItems().forEach(item -> {
                    System.out.println("-------------------------------------------------------");
                    System.out.println("Channel title = " + item.getSnippet().getChannelTitle());
                    System.out.println("Video title = " + item.getSnippet().getTitle());
                    System.out.println("Video id = " + item.getId().getVideoId());
                });
                response.body().close();
            }
        });
        //https://stackoverflow.com/questions/31183730/okhttp-asynchronous-request-doesnt-stop-immediately-after-onresponse
        //Проблема заключается в том, что при ассинхронном вызове создается executor service, в котором создаются потоки
        //и он не дает закончить работу нашего приложения.
        //По этому, добавьте свою реализацию executor сервиса и диспетчера, который вы в конце работы приложения спокойно
        //остановите.
        CLIENT.dispatcher().executorService().shutdown();
    }

    private static HttpUrl prepareHttpUrl() {
        return HttpUrl.parse(ROOT_URL).newBuilder()
                .addPathSegment("youtube")
                .addPathSegment("v3")
                .addPathSegment("search")
                .addQueryParameter("part", "snippet")
                .addQueryParameter("channelId", "UCo_q6aOlvPH7M-j_XGWVgXg")
                .addQueryParameter("maxResults", "10")
                .addQueryParameter("oder", "date")
                .addQueryParameter("type", "video")
                .addQueryParameter("key", "API_KEY") // insert your API_KEY
                .build();
    }
}
