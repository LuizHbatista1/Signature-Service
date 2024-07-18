package com.api.system_transaction.infra.constants;

import com.api.system_transaction.domain.user.User;

public class BodyConstants {

    public BodyConstants(User user) {


        String choosePlan = user.getProductId().getTitle();

        final String BODY_CONSTANTS = "thanks to choose the plan" + choosePlan;

    }
}
