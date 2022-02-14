package br.manogarrafa.buscafilme;

public class ApiCall {
    public void whenAsynchronousGetRequest_thenCorrect() {
        Request request = new Request.Builder()
                .url(BASE_URL + "/date")
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            public void onResponse(Call call, Response response)
                    throws IOException {
                // ...
            }

            public void onFailure(Call call, IOException e) {
                fail();
            }
        });
    }
}
