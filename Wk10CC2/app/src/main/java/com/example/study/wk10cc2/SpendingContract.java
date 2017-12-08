package com.example.study.wk10cc2;

import android.provider.BaseColumns;

/**
 * Created by study on 28/11/17.
 */

public class SpendingContract {
    public static final class SpendingEntry implements BaseColumns {

        public static final String TABLE_NAME = "SpendingRecord";
        public static final String COL_AMOUNT = "Amount";
        public static final String COL_REMARKS = "Remarks";

    }
}
