package com.shangguigu;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ListView listView;
	private SpannableStringBuilder ssb;
	List<SpannableStringBuilder> spannablesbList;

	private final int line_color = 0xAAAAAAAA;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView text = new TextView(this);
		StringBuilder sb = new StringBuilder("����HTML:");
		sb.append("<img src=\"" + R.drawable.icon_pic + "\">");
		CustomImageGetter imageGetter = new CustomImageGetter(this, CustomImageGetter.DEFAULT,
				CustomImageGetter.DEFAULT);
		text.setText(Html.fromHtml(sb.toString(), imageGetter, null));

		listView = (ListView) findViewById(R.id.lvShowText);
		setSpannableSBText();
		listView.addHeaderView(text);
		listView.setAdapter(new ListViewAdapter(MainActivity.this, spannablesbList));
	}

	private void setSpannableSBText() {
		if (spannablesbList == null)
			spannablesbList = new ArrayList<SpannableStringBuilder>();

		/**
		 * Mark the specified range of text with the specified object.<br>
		 * ���ָ���ķ�Χʹ��ָ����Object The flags determine how the span will behave when
		 * text is inserted at the start or end of the span's range.<br>
		 * flags�����˷�Χ�Ŀ������
		 */
		ssb = new SpannableStringBuilder("Ϊָ��������[1,4)����ָ������ɫ");
		ssb.setSpan(new ForegroundColorSpan(Color.GREEN), 1, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);// ����ʹ��_1��Ϊָ������������ָ������ɫ
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("׷���ַ�");
		ssb.append("fuck!");// ����ʹ��_2:׷���ַ�
		ssb.setSpan(new ForegroundColorSpan(Color.RED), 4, 8, Spannable.SPAN_MARK_POINT);
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("�������屳��ɫ ");
		ssb.setSpan(new BackgroundColorSpan(Color.GRAY), new String("��������").length(), new String("�������屳��ɫ ").length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // ���ñ���ɫΪ��ɫ
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("�������屳��ɫ Longֵ��ʽ");
		ssb.setSpan(new BackgroundColorSpan(line_color), new String("��������").length(), new String("�������屳��ɫ ").length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // ���ñ���ɫΪ��ɫ
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("�����»���");
		// �����»���
		ssb.setSpan(new UnderlineSpan(), 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("����ɾ����");
		ssb.setSpan(new StrikethroughSpan(), 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("�������±�:y=x3+An");
		//
		ssb.setSpan(new SuperscriptSpan(), new String("�������±�:y=x").length(), new String("�������±�:y=x2").length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // �±�
		ssb.setSpan(new SubscriptSpan(), new String("�������±�:y=x3+a").length(), new String("�������±�:y=x3+an").length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // �ϱ�
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("��������:�绰 ");
		ssb.setSpan(new URLSpan("tel:13912345678"), 5, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // �绰
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("��������:�ʼ� ");
		ssb.setSpan(new URLSpan("mailto:webmaster@google.com"), 5, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // �ʼ�
		ssb.setSpan(new ForegroundColorSpan(Color.YELLOW), 5, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("��������:���� ");
		ssb.setSpan(new URLSpan("http://www.baidu.com"), 5, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // ����
		ssb.setSpan(new ForegroundColorSpan(Color.LTGRAY), 5, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("��������:���� ");
		ssb.setSpan(new URLSpan("sms:13912345678"), 5, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // ����
		ssb.setSpan(new ForegroundColorSpan(Color.BLUE), 5, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("��������:��ͼ ");
		ssb.setSpan(new URLSpan("geo:38.899533,-77.036476"), 5, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //
		ssb.setSpan(new ForegroundColorSpan(Color.GREEN), 5, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannablesbList.add(ssb);

		// ע�⣺�������Ӻ�ָ��������ı�������ɫ������ס��ǰ���õ���ɫ������Ӧ���������Ӻ���Ϊָ�����������������ɫ
		ssb = new SpannableStringBuilder("��������:�ı� ");
		ssb.setSpan(new URLSpan("cacaca") {
			@Override
			public void onClick(View widget) {
				Toast.makeText(MainActivity.this, "��������õ�����", 0).show();
			}
		}, 5, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new ForegroundColorSpan(Color.RED), 5, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("������Ŀ����");
		ssb.setSpan(new BulletSpan(android.text.style.BulletSpan.STANDARD_GAP_WIDTH, Color.GREEN), 0,
				new String("������Ŀ����").length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // ��һ��������ʾ��Ŀ����ռ�õĿ�ȣ��ڶ�������Ϊ��Ŀ���ŵ���ɫ
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("����������ʽ���������壬б�壬��б�� ");
		// ����������ʽ���������壬б�壬��б��
		ssb.setSpan(new StyleSpan(android.graphics.Typeface.NORMAL), 6, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // ����
		ssb.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 9, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // ����
		ssb.setSpan(new StyleSpan(android.graphics.Typeface.ITALIC), 12, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // б��
		ssb.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC), 15, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // ��б��
		spannablesbList.add(ssb);

		// ��������(default,default-bold,monospace,serif,sans-serif)
		String str = "��������(default,default-bold,monospace,serif,sans-serif)";
		ssb = new SpannableStringBuilder(str);
		ssb.setSpan(new TypefaceSpan("default"), 0, new String("��������(default,").length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new TypefaceSpan("default-bold"), new String("��������(default,").length(),
				new String("��������(default,default-bold,").length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new TypefaceSpan("monospace"), new String("��������(default,default-bold,").length(),
				new String("��������(default,default-bold,monospace,").length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new TypefaceSpan("serif"), new String("��������(default,default-bold,monospace,").length(),
				new String("��������(default,default-bold,monospace,serif,").length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new TypefaceSpan("sans-serif"), new String("��������(default,default-bold,monospace,serif,").length(),
				new String("��������(default,default-bold,monospace,serif,sans-serif)").length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("���������С(����ֵ����λ:����/��λ:����)");
		ssb.setSpan(new AbsoluteSizeSpan(20), new String("���������С(����ֵ,").length(),
				new String("���������С(����ֵ,��λ:����,").length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new AbsoluteSizeSpan(20, true), new String("���������С(����ֵ,��λ:����,").length(),
				new String("���������С(����ֵ,��λ:����,��λ:����)").length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // �ڶ�������boolean
		// dip�����Ϊtrue����ʾǰ��������С��λΪdip������Ϊ���أ���ͬ
		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("���������С�����ֵ��һ��/����,��λ�����أ� ������ʾΪĬ�������С�Ķ��ٱ� ");
		ssb.setSpan(new RelativeSizeSpan(0.5f), new String("���������С�����ֵ��").length(),
				new String("���������С�����ֵ��һ��/").length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 0.5f��ʾĬ�������С��һ��
		ssb.setSpan(new RelativeSizeSpan(2.0f), new String("���������С�����ֵ��һ��/").length(),
				new String("���������С�����ֵ��һ��/����,").length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 2.0f��ʾĬ�������С������
		spannablesbList.add(ssb);
		String aa = "�ҵĺ������ͼƬ";
		aa = aa + " ";
		ssb = new SpannableStringBuilder(aa);
		ssb.setSpan(new ImageSpan(this, R.drawable.ic_launcher), aa.length() - 1, aa.length(),
				Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("�ҵ��� �����ͼƬ  ");
		ssb.setSpan(new ImageSpan(this, R.drawable.ic_launcher), 3, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		spannablesbList.add(ssb);
		String bb = "�ҵ�ǰ�����ͼƬ";
		bb = " " + bb;
		ssb = new SpannableStringBuilder(bb);
		ssb.setSpan(new ImageSpan(this, R.drawable.ic_launcher), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("ͼƬ����¼��Ĵ���  ");
		ssb.setSpan(new ImageSpan(this, R.drawable.ic_launcher), 3, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		ssb.setSpan(new ClickableSpan() {
			@Override
			public void onClick(View widget) {
				Toast.makeText(MainActivity.this, "ͼƬ����¼��Ĵ��� ", 0).show();
			}
		}, 3, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("�����ӵĵ��Ч��");
		ssb.setSpan(new ClickableSpan() {
			@Override
			public void onClick(View widget) {
				Toast.makeText(MainActivity.this, "�����ӵĵ��Ч��", 0).show();
			}
		}, 3, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		spannablesbList.add(ssb);

		ssb = new SpannableStringBuilder("�����ӵĵ��Ч��");
		ssb.setSpan(new ClickableSpan() {
			@Override
			public void onClick(View widget) {
				Toast.makeText(MainActivity.this, "�����ӵĵ��Ч��", 0).show();
			}

			public void updateDrawState(TextPaint ds) {
				ds.setUnderlineText(false);
			}
		}, 3, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

		spannablesbList.add(ssb);
	}

	public static class CustomImageGetter implements Html.ImageGetter {
		public static final int DEFAULT = -1;
		int mRight;
		int mBottom;
		Context mContext;

		public CustomImageGetter(Context context, int right, int bottom) {
			mRight = right;
			mBottom = bottom;
			mContext = context;
		}

		@Override
		public Drawable getDrawable(String source) {
			int id = Integer.parseInt(source);
			Drawable d = mContext.getResources().getDrawable(id);
			if (null != d) {
				d.setBounds(0, 0, mRight == DEFAULT ? d.getIntrinsicWidth() : mRight,
						mBottom == DEFAULT ? d.getIntrinsicHeight() : mBottom);
			}
			return d;
		}
	}

}
