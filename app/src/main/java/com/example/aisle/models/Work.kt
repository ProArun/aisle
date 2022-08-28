package  com.example.aisle.models

import com.google.gson.annotations.SerializedName


data class Work(

    @SerializedName("industry_v1") var industryV1: IndustryV1? = IndustryV1(),
    @SerializedName("monthly_income_v1") var monthlyIncomeV1: String? = null,
    @SerializedName("experience_v1") var experienceV1: ExperienceV1? = ExperienceV1(),
    @SerializedName("highest_qualification_v1") var highestQualificationV1: HighestQualificationV1? = HighestQualificationV1(),
    @SerializedName("field_of_study_v1") var fieldOfStudyV1: FieldOfStudyV1? = FieldOfStudyV1()

)