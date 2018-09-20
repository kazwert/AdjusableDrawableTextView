# AdjusableDrawableTextView
This class is customization from TextView to handle drawable. On this text view, drawable will adjust with text size.
The XML example :

              <com.koki.android.presentation.custom.DrawableTextView
                    android:id="@+id/dtv_topup"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:drawablePadding="@dimen/margin_4"
                    app:setIconLeft="@drawable/ic_koinku"
                    android:textSize="@dimen/font_14"
                    android:text="test"/>
                    

This class is extend by TextView class.
To set the drawable on the left you just put code below on XML

```XML
app:setIconLeft="@drawable/ic_koinku"
```

on Programaticly in java is below 

```java
dtvTopup.setDrawable(getResources().getDrawable(R.drawable.ic_koinku),null,null,null);
```
