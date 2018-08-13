package com.example.zongm.zxingapplication;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;

    private ImageView mIv;
    private TextView mTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.edit);
        mIv = findViewById(R.id.iv);
        mTV = findViewById(R.id.tv);
        findViewById(R.id.btn_qr).setOnClickListener((view) -> {
            String content = mEditText.getText().toString();
            if (!TextUtils.isEmpty(content)) {
                Bitmap qrCode = EncodingUtils.createQRCode(content, 1000,
                    1000, null);
                mIv.setImageBitmap(qrCode);
                mTV.setText(content);
            }
        });
        //生成条形码
        findViewById(R.id.btn_br).setOnClickListener((view) -> {
            String content = mEditText.getText().toString();
            if (!TextUtils.isEmpty(content)) {
                Bitmap qrCode = EncodingUtils.createBarcode(content, 700,
                    300, false);
                mIv.setImageBitmap(qrCode);
                mTV.setText(content);
            }
        });
    }
}
