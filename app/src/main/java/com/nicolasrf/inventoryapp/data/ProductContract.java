/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nicolasrf.inventoryapp.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class ProductContract {

    public static final String LOG_TAG = ProductProvider.class.getSimpleName();

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private ProductContract() {
    }

    /**
     * Building URI
     */
    // authority
    public static final String CONTENT_AUTHORITY = "com.nicolasrf.inventoryapp";
    // base content URI
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    // path to table name
    public static final String PATH_PRODUCTS = "products";

    /**
     * Inner class that defines constant values for the products database table.
     * Each entry in the table represents a single product.
     */

    public static abstract class ProductEntry implements BaseColumns {

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of products.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single product.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;


        /**
         * The content URI to access the product data in the provider
         */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PRODUCTS);

        /**
         * Name of database table for products
         */
        public final static String TABLE_NAME = "products";

        /**
         * Unique ID number for the product (only for use in the database table).
         * <p>
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the product.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_PRODUCT_NAME = "name";

        /**
         * Model of the product.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_PRODUCT_MODEL = "model";

        /**
         * Type of the product.
         * <p>
         * Type: INTEGER
         */
        public final static String COLUMN_PRODUCT_TYPE = "type";

        /**
         * Quantity of the product.
         * <p>
         * Type: INTEGER
         */
        public final static String COLUMN_PRODUCT_QUANTITY = "quantity";

        /**
         * Quantity of the product.
         * <p>
         * Type: TEXT
         */
        public static final String COLUMN_PRODUCT_PICTURE = "picture";

        /**
         * Price of the product.
         * <p>
         * Type: INTEGER
         */
        public final static String COLUMN_PRODUCT_PRICE = "price";

        /**
         * Name of the supplier.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_SUPPLIER_NAME = "supplierName";

        /**
         * Name of the supplier.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_SUPPLIER_EMAIL = "supplierEmail";

        /**
         * Possible values for the type of the product.
         */
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_LAPTOP = 1;
        public static final int TYPE_SMARTHPHONE = 2;
        public static final int TYPE_TV = 3;

        /**
         * Returns whether or not the given grade is {@link #TYPE_UNKNOWN}, {@link #TYPE_LAPTOP}, {@link #TYPE_SMARTHPHONE},
         * or {@link #TYPE_TV}.
         */
        public static boolean isValidType(int type) {
            if (type == TYPE_UNKNOWN || type == TYPE_LAPTOP || type == TYPE_SMARTHPHONE || type == TYPE_TV) {
                return true;
            }
            return false;
        }
    }

}