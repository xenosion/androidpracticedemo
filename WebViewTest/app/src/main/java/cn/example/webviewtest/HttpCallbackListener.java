package cn.example.webviewtest;

public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
