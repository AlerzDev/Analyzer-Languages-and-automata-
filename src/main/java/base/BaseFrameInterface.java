package base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lemuz on 3/12/16.
 */
public interface BaseFrameInterface {
    void initView();
    void success(final String title, final String msg);
    void error(final String title, final String msg);
}
