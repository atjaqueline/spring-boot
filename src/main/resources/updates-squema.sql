CREATE TABLE updates (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    affected_team VARCHAR(50) NOT NULL,
    description VARCHAR NOT NULL,
    optional_details VARCHAR NOT NULL,
    submited_by VARCHAR(25) NOT NULL
);

{
    "title": "Personalization and Customer Journey Mapping",
    "affected_team":"Latam Marketing",
    "description": "Recognizing the importance of personalized experiences, our marketing team has implemented a customer journey mapping initiative. We are using data and analytics to understand our customers' preferences, pain points, and behaviors at each stage of their journey.",
    "optional_details": "By leveraging this information, we are creating tailored marketing campaigns, personalized emails, and customized offers. This approach has significantly improved customer satisfaction, increased conversion rates, and fostered long-term brand loyalty.",
    "submited_by":"C Ronaldo"
}

{
    "title": "Influencer Partnership Program",
    "affected_team":"Latam Marketing",
    "description": "We have identified key influencers in our industry who align with our brand values and target audience. We have successfully established mutually beneficial partnerships with these influencers to promote our products and services.",
    "optional_details": "Our team is constantly identifying new influencers and monitoring campaign performance to ensure maximum ROI.",
    "submited_by":"Carla"
}

