/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agit.crm.main.viewmodel.customer.feedback;

import org.zkoss.chart.model.CategoryModel;
import org.zkoss.chart.model.DefaultCategoryModel;

/**
 *
 * @author BayuHS
 */
public class ColumnBasicData {

    private static CategoryModel model;

    static {
        model = new DefaultCategoryModel();
        model.setValue("Sangat Puas", "Jan", 49.9);
        model.setValue("Sangat Puas", "Feb", 71.5);
        model.setValue("Sangat Puas", "Mar", 106.4);
        model.setValue("Sangat Puas", "Apr", 129.2);
        model.setValue("Sangat Puas", "May", 144.0);
        model.setValue("Sangat Puas", "Jun", 176.0);
        model.setValue("Sangat Puas", "Jul", 135.6);
        model.setValue("Sangat Puas", "Aug", 148.5);
        model.setValue("Sangat Puas", "Sep", 216.4);
        model.setValue("Sangat Puas", "Oct", 194.1);
        model.setValue("Sangat Puas", "Nov", 95.6);
        model.setValue("Sangat Puas", "Dec", 54.4);
        model.setValue("Puas", "Jan", 83.6);
        model.setValue("Puas", "Feb", 78.8);
        model.setValue("Puas", "Mar", 98.5);
        model.setValue("Puas", "Apr", 93.4);
        model.setValue("Puas", "May", 106.0);
        model.setValue("Puas", "Jun", 84.5);
        model.setValue("Puas", "Jul", 105.0);
        model.setValue("Puas", "Aug", 104.3);
        model.setValue("Puas", "Sep", 91.2);
        model.setValue("Puas", "Oct", 83.5);
        model.setValue("Puas", "Nov", 106.6);
        model.setValue("Puas", "Dec", 92.3);
        model.setValue("Kurang Puas", "Jan", 48.9);
        model.setValue("Kurang Puas", "Feb", 38.8);
        model.setValue("Kurang Puas", "Mar", 39.3);
        model.setValue("Kurang Puas", "Apr", 41.4);
        model.setValue("Kurang Puas", "May", 47.0);
        model.setValue("Kurang Puas", "Jun", 48.3);
        model.setValue("Kurang Puas", "Jul", 59.0);
        model.setValue("Kurang Puas", "Aug", 59.6);
        model.setValue("Kurang Puas", "Sep", 52.4);
        model.setValue("Kurang Puas", "Oct", 65.2);
        model.setValue("Kurang Puas", "Nov", 59.3);
        model.setValue("Kurang Puas", "Dec", 51.2);
        model.setValue("Kecewa", "Jan", 42.4);
        model.setValue("Kecewa", "Feb", 33.2);
        model.setValue("Kecewa", "Mar", 34.5);
        model.setValue("Kecewa", "Apr", 39.7);
        model.setValue("Kecewa", "May", 52.6);
        model.setValue("Kecewa", "Jun", 75.5);
        model.setValue("Kecewa", "Jul", 57.4);
        model.setValue("Kecewa", "Aug", 60.4);
        model.setValue("Kecewa", "Sep", 47.6);
        model.setValue("Kecewa", "Oct", 39.1);
        model.setValue("Kecewa", "Nov", 46.8);
        model.setValue("Kecewa", "Dec", 51.1);

        model.setValue("Bingung", "Jan", 42.4);
        model.setValue("Bingung", "Feb", 33.2);
        model.setValue("Bingung", "Mar", 34.5);
        model.setValue("Bingung", "Apr", 39.7);
        model.setValue("Bingung", "May", 52.6);
        model.setValue("Bingung", "Jun", 75.5);
        model.setValue("Bingung", "Jul", 57.4);
        model.setValue("Bingung", "Aug", 60.4);
        model.setValue("Bingung", "Sep", 47.6);
        model.setValue("Bingung", "Oct", 39.1);
        model.setValue("Bingung", "Nov", 46.8);
        model.setValue("Bingung", "Dec", 51.1);
    }

    public static CategoryModel getCategoryModel() {
        return model;
    }
}
