package hammertime.com.payday.ui;

import android.support.v4.app.Fragment;

public class WorkdayListActivity extends SingleFragmentActivity
{
    @Override
    protected Fragment createFragment()
    {
        return new WorkdayListFragment();
    }
}