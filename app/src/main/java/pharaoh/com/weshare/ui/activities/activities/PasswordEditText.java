package pharaoh.com.weshare.ui.activities.activities;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

/**
 * Created by MahmoudAhmed on 2/5/2018.
 */

public class PasswordEditText extends EditText {
    public PasswordEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public PasswordEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PasswordEditText(Context context) {
        super(context);
        init();
    }

    private void init() {
      /** if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/raleway-semibold.ttf");
            setTypeface(tf);
        }**/

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == View.LAYOUT_DIRECTION_RTL) {
                        if (event.getRawX() >= getLeft() - getTotalPaddingLeft()) {

                            if (getTag().toString().equals("hidden")) {
                                setTransformationMethod(PasswordTransformationMethod.getInstance());
                                setTag("visible");
                                setSelection(getText().length());

                            } else {
                                setTransformationMethod(null);
                                setTag("hidden");
                                setSelection(getText().length());

                            }

                        }
                    } else {
                        if (event.getRawX() >= getRight() - getTotalPaddingRight())
                        {
                            if (getTag().toString().equals("hidden")) {
                                setTransformationMethod(PasswordTransformationMethod.getInstance());
                                setTag("visible");
                                setSelection(getText().length());

                            } else {
                                setTransformationMethod(null);
                                setTag("hidden");
                                setSelection(getText().length());

                            }
                        }
                    }

                }
                return false;
            }
        });
    }
}
