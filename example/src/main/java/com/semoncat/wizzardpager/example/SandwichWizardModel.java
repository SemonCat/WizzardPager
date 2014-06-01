package com.semoncat.wizzardpager.example;

import android.content.Context;
import com.semoncat.wizzardpager.model.*;
import com.semoncat.wizzardpager.ui.PageFragmentCallbacks;

/**
 * Created by SemonCat on 2014/6/1.
 */
public class SandwichWizardModel extends AbstractWizardModel {
    private PageFragmentCallbacks mPageFragmentCallbacks;

    public SandwichWizardModel(PageFragmentCallbacks pageFragmentCallbacks,Context context) {
        super(pageFragmentCallbacks,context);
        this.mPageFragmentCallbacks = pageFragmentCallbacks;
    }

    @Override
    protected PageList onNewRootPageList() {
        return new PageList(new BranchPage(mPageFragmentCallbacks,this, "Order type").addBranch(
                "Sandwich",
                new SingleFixedChoicePage(mPageFragmentCallbacks,this, "Bread").setChoices("White",
                        "Wheat", "Rye", "Pretzel", "Ciabatta")
                        .setRequired(true),

                new MultipleFixedChoicePage(mPageFragmentCallbacks,this, "Meats").setChoices(
                        "Pepperoni", "Turkey", "Ham", "Pastrami", "Roast Beef",
                        "Bologna"),

                new MultipleFixedChoicePage(mPageFragmentCallbacks,this, "Veggies").setChoices(
                        "Tomatoes", "Lettuce", "Onions", "Pickles",
                        "Cucumbers", "Peppers"),

                new MultipleFixedChoicePage(mPageFragmentCallbacks,this, "Cheeses").setChoices(
                        "Swiss", "American", "Pepperjack", "Muenster",
                        "Provolone", "White American", "Cheddar", "Bleu"),

                new BranchPage(mPageFragmentCallbacks,this, "Toasted?")
                        .addBranch(
                                "Yes",
                                new SingleFixedChoicePage(mPageFragmentCallbacks,this, "Toast time")
                                        .setChoices("30 seconds", "1 minute",
                                                "2 minutes")).addBranch("No")
                        .setValue("No"))

                .addBranch(
                        "Salad",
                        new SingleFixedChoicePage(mPageFragmentCallbacks,this, "Salad type").setChoices(
                                "Greek", "Caesar").setRequired(true),

                        new SingleFixedChoicePage(mPageFragmentCallbacks,this, "Dressing").setChoices(
                                "No dressing", "Balsamic", "Oil & vinegar",
                                "Thousand Island", "Italian").setValue("No dressing"),
                        new NumberPage(mPageFragmentCallbacks,this, "How Many Salads?").setRequired(true)),
                new TextPage(mPageFragmentCallbacks,this, "Comments").setRequired(true)

                        .setRequired(true),

                new CustomerInfoPage(mPageFragmentCallbacks,this, "Your info").setRequired(true));
    }
}
