package com.retail.dtos;

import com.retail.entities.ModelName;

public record FeedbackReport(ModelName modelName,int seatingCapacity, float averageFeedback) {
}
