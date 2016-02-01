package me.yamlee.demo.net;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import me.yamlee.demo.R;


public class SecureActivity extends Activity {
	private EditText et_secure_input = null;
	String aes_encrpt = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_secure);
		et_secure_input = (EditText) findViewById(R.id.et_secure_input);
	}

	public String encode_md5(String src) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(src.getBytes());
		return Base64.encodeToString(messageDigest.digest(), Base64.DEFAULT);
	}

	public String encode_sha(String src) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
		messageDigest.update(src.getBytes());
		return Base64.encodeToString(messageDigest.digest(), Base64.DEFAULT);
	}

	public static String initMacKey() throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
		SecretKey secretKey = keyGenerator.generateKey();
		return Base64.encodeToString(secretKey.getEncoded(), Base64.DEFAULT);
	}

	public String encode_hmac(String key, String src) throws NoSuchAlgorithmException, InvalidKeyException {
		SecretKey secretkey = new SecretKeySpec(Base64.decode(key.getBytes(), Base64.DEFAULT), "HmacMD5");
		Mac mac = Mac.getInstance(secretkey.getAlgorithm());
		mac.init(secretkey);
		return Base64.encodeToString(mac.doFinal(src.getBytes()), Base64.DEFAULT);
	}

	public String encode_aes(String key, String src) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		if (key == null || key.length() != 16) {
			return "keyֵ����ȷ";
		}
		SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec ivParameterSpec = new IvParameterSpec("0102030405060708".getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		return Base64.encodeToString(cipher.doFinal(src.getBytes()), Base64.DEFAULT);
	}

	public String decode_aes(String key, String encrptStr) throws Exception {
		if (key == null || key.length() != 16) {
			return "keyֵ����ȷ";
		}
		SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec ivParameterSpec = new IvParameterSpec("0102030405060708".getBytes());
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
		return new String(cipher.doFinal(Base64.decode(encrptStr.getBytes(),Base64.DEFAULT)));
	}

	public void on_click(View v) {

		String src = "";
		if (TextUtils.isEmpty(et_secure_input.getText())) {
			Toast.makeText(this, "��������Ϊ�գ�", Toast.LENGTH_SHORT).show();
			return;
		} else {
			src = et_secure_input.getText().toString();
		}
		switch (v.getId()) {
		case R.id.btn_md5:
			try {
				String encodeStr = encode_md5(src);
				showMyDialog(encodeStr);
				showLog("--md5--  " + encodeStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case R.id.btn_aes:
			try {
				if (TextUtils.isEmpty(aes_encrpt)) {
					String encodeStr = encode_aes("1122334455667788", src);
					showMyDialog(encodeStr);
					aes_encrpt = encodeStr;
					showLog("-encode aes--  " + encodeStr);
					et_secure_input.setText(encodeStr);
					Button button = (Button)findViewById(R.id.btn_aes);
					button.setText("AES����");
				} else {
					String decodeStr = decode_aes("1122334455667788", aes_encrpt);
					showMyDialog(decodeStr);
					showLog("----decode aes--- " + decodeStr);
					Button button = (Button)findViewById(R.id.btn_aes);
					button.setText("AES����");
					aes_encrpt = null;
					et_secure_input.setText("");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case R.id.btn_hmac:
			try {
				String encodeStr = encode_hmac(initMacKey(), src);
				showLog("----sha----" + encodeStr);
				showMyDialog(encodeStr);
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
		case R.id.btn_sha:
			try {
				String encodeStr = encode_sha(src);
				showLog("----sha----" + encodeStr);
				showMyDialog(encodeStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	private void showMyDialog(String msg) {
		AlertDialog.Builder builder = new AlertDialog.Builder(SecureActivity.this);
		builder.setTitle("���ܽ��");
		builder.setMessage(msg);
		builder.show();
	}

	private void showLog(String msg) {
		System.out.println(msg);
	}
}
