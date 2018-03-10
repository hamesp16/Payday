package hammertime.com.payday.ui;

import android.support.v4.app.Fragment;

public class WorkdayActivity extends SingleFragmentActivity
{
    @Override
    protected Fragment createFragment()
    {
        return new WorkdayFragment();
    }
}
