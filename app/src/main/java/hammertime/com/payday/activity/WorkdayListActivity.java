package hammertime.com.payday.activity;

import hammertime.com.payday.fragment.WorkdayListFragment;
import android.support.v4.app.Fragment;

public class WorkdayListActivity extends SingleFragmentActivity
{
    @Override
    protected Fragment createFragment()
    {
        return new WorkdayListFragment();
    }
}