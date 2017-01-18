package com.aries.ratingdialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.TextView;

public final class RatingDailog extends AlertDialog
{
	private final RatingDialogListener mCallBack;

	private TextView tvContent;
	private Button btnRateMe;
	private Button btnNoThanks;
	private Button btnLater;
	private String mContent;

	private AnimationSet mModalInAnim;

	private View dialogView;

	private int iconId = R.mipmap.ic_launcher;

	public interface RatingDialogListener {
		void OnRateMe();
		void OnNoThanks();
		void OnLater();
	}

//	public RatingDailog setTitle (String title){
//		super.setTitle (title);
//		return this;
//	}

	public RatingDailog setContent (String content){
		mContent = content;
		tvContent.setText(mContent);
		return this;
	}

	public RatingDailog setTitleIcon (int iconId){
		this.iconId = iconId;
		setIcon(iconId);
		return this;
	}

	public RatingDailog setRateMeButtonText (String rateMe){
		btnRateMe.setText(rateMe);
		return this;
	}

	public RatingDailog setNoThanksButtonText (String noThanks){
		btnNoThanks.setText(noThanks);
		return this;
	}

	public RatingDailog setReminderMeLaterButtonText (String reminderLater){
		btnLater.setText(reminderLater);
		return this;
	}

	protected void onStart() {
		dialogView.startAnimation(mModalInAnim);
	}

	@Override
	public void show() {

		super.show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		dialogView = findViewById(android.R.id.content);
	}

	public RatingDailog (Context context,
						 RatingDialogListener callBack) {
		super(context, R.style.rating_alert_dialog);//The Window animation needs that.

		mModalInAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.modal_in);

		mCallBack = callBack;

		setIcon(iconId);


//		super.setTitle (R.string.erd_title);

		LayoutInflater inflater =
				(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


		View view = inflater.inflate(R.layout.rating_diaglog, null);
		setView(view);

		tvContent = (TextView)view.findViewById (R.id.tvContent);
		btnRateMe = (Button)view.findViewById(R.id.btnRateMe);
		btnNoThanks = (Button)view.findViewById(R.id.btnNoThanks);
		btnLater = (Button)view.findViewById(R.id.btnLater);



		if (mCallBack == null){
			return;
		}

		btnRateMe.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mCallBack.OnRateMe();
				dismiss();
			}
		});
		btnNoThanks.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mCallBack.OnNoThanks();
				dismiss();
			}
		});
		btnLater.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mCallBack.OnLater();
				dismiss();
			}
		});
	}
}