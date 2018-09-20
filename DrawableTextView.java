public class DrawableTextView extends AppCompatTextView {

    private Drawable left;
    private Drawable top;
    private Drawable right;
    private Drawable bottom;

    public DrawableTextView(Context context) {
        super(context);
    }

    public DrawableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DrawableTextView);

        int leftId = a.getResourceId(R.styleable.DrawableTextView_setIconLeft, 0);
        int topId = a.getResourceId(R.styleable.DrawableTextView_setIconTop, 0);
        int rightId = a.getResourceId(R.styleable.DrawableTextView_setIconRight, 0);
        int bottomId = a.getResourceId(R.styleable.DrawableTextView_setIconBottom, 0);
        if (leftId != 0) left = AppCompatResources.getDrawable(context,leftId);
        if (topId != 0) top = AppCompatResources.getDrawable(context,topId);
        if (rightId != 0) right = AppCompatResources.getDrawable(context,rightId);
        if (bottomId != 0) bottom = AppCompatResources.getDrawable(context,bottomId);
        a.recycle();
        init();
    }

    public DrawableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {

            setDrawable(left,top, right,bottom);
    }


    public void setDrawable(@Nullable Drawable left, @Nullable Drawable top,
        @Nullable Drawable right, @Nullable Drawable bottom) {
        float textSize = getTextSize() < 30 ? getTextSize() + 16 : getTextSize() + 20;
        int textSizePx = dpToPx(textSize, getContext());

        BitmapDrawable bdLeft = null;
        BitmapDrawable bdRight = null;
        BitmapDrawable bdTop = null;
        BitmapDrawable bdBottom = null;

        Bitmap bitmap = Bitmap.createBitmap(textSizePx, textSizePx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        if (left != null) {
            left.setBounds(0, 0, textSizePx, textSizePx);
            left.draw(canvas);
            bdLeft = new BitmapDrawable(bitmap);
        }

        if (right != null) {
            right.setBounds(0, 0, textSizePx, textSizePx);
            right.draw(canvas);
            bdRight = new BitmapDrawable(bitmap);
        }

        if (top != null) {
            top.setBounds(0, 0, textSizePx, textSizePx);
            top.draw(canvas);
            bdTop = new BitmapDrawable(bitmap);
        }

        if (bottom != null) {
            bottom.setBounds(0, 0, textSizePx, textSizePx);
            bottom.draw(canvas);
            bdBottom = new BitmapDrawable(bitmap);
        }

        setCompoundDrawablesWithIntrinsicBounds(bdLeft, bdTop, bdRight, bdBottom);
    }

    private static int dpToPx(float dp, Context context) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }
}
