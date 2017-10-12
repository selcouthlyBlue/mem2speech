package gonzalvo.dpsm.cas.upm.edu.ph.mem2speech.canvas;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import gonzalvo.dpsm.cas.upm.edu.ph.mem2speech.HandwrittenTextSourceFragment;
import gonzalvo.dpsm.cas.upm.edu.ph.mem2speech.R;

public class CanvasFragment extends Fragment implements HandwrittenTextSourceFragment {

    private DrawingView drawingView;
    private boolean isPen;
    private Button button_writingTool;

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return createUI(inflater.inflate(R.layout.fragment_canvas, container, false));
    }

    private View createUI(View view) {
        isPen = true;
        drawingView = (DrawingView) view.findViewById(R.id.drawing);

        Button button_clear = (Button) view.findViewById(R.id.button_clear);
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.clearCanvas();
            }
        });

        button_writingTool = (Button) view.findViewById(R.id.button_writing_tool);
        button_writingTool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawingView.switchTool();
                switchButton();
            }

            private void switchButton() {
                if(isPen){
                    button_writingTool.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_eraser, 0, 0);
                    button_writingTool.setText(getResources().getString(R.string.button_erase));
                    isPen = false;
                } else {
                    button_writingTool.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.ic_pen, 0, 0);
                    button_writingTool.setText(getResources().getString(R.string.button_stroke));
                    isPen = true;
                }
            }
        });
        return view;
    }

    @Override
    public Bitmap getImage() {
        drawingView.setDrawingCacheEnabled(true);
        drawingView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        return drawingView.getDrawingCache();
    }
}
