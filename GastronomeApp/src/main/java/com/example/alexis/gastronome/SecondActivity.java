package com.example.alexis.gastronome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private ImageView foodImage;
    private TextView name;
    private TextView Description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_actitvity);

        foodImage = (ImageView)findViewById(R.id.foodImage);
        name =(TextView) findViewById(R.id.title);
        Description=(TextView) findViewById(R.id.description);

        Intent intent = getIntent();
        int x = intent.getIntExtra("Image Resource",0);
        String y = intent.getStringExtra("Title");
        foodImage.setImageResource(x);
        name.setText(y);

        if(y.equals("Salmon"))
        {
            Description.setText("Ingredients\n " +
                            "4 4 ounce salmon filets "+
                    "1 tbsp balsamic vinegar\n"+
                    "2 tbsp extra virgin olive oil\n"+
                    "¼ cup lemon juice\n"+
                    "1 tsp garlic powder\n"+
                    "1 tbsp rosemary\n"+
                    "sea salt to taste\n"+
                    "Steps\n"+
                    "Place salmon fillets in a glass dish\n" +
                    "Combine all glaze ingredients in a small bowl\n" +
                    "Drizzle glaze over salmon fillets\n" +
                    "Refrigerate 20 minutes minimum, it can be marinated longer if you want\n" +
                    "Remove salmon from glass dish and cook as desired\n" +
                    "I seared mine on the stove top, cooking on medium heat 7 minutes with the skin side facing down first then flipping & cooking 3 minutes more\n" +
                    "Plate with your favorite veggie, I plated mine with broccoli carrot slaw");
        }
        else if(y.equals("Pizza"))
        {
            Description.setText("Ingredients\n"+
                    "1 (.25 ounce) package active dry yeast\n"+
                    "1 teaspoon white sugar\n" +
                    "1 cup warm water\n"+
                    "2 1/2 cups bread flour\n"+
                    "2 tablespoons olive oil\n"+
                    "1 teaspoon salt\n"+
                    "Steps"+
                    "Preheat oven to 450 degrees\n"+
                    "In a medium bowl, dissolve yeast and sugar in warm water\n"+
                    "Let stand until creamy, about 10 minutes\n"+
                    "Stir in flour, salt and oil\n"+
                    "Beat until smooth\n"+
                    "Let rest for 5 minutes\n"+
                    "Turn dough out onto a lightly floured surface and pat or roll into a round\n"+
                    "Transfer crust to a lightly greased pizza pan or baker's peel dusted with cornmeal\n" +
                    "Spread with desired toppings and bake in preheated oven for 15 to 20 minutes, or until golden brown\n" +
                    "Let baked pizza cool for 5 minutes before serving");
        }
        else if(y.equals("Burger"))
        {
         Description.setText("Ingredients\n"+
                 "2 lbs. ground beef\n" +
                 "2 tsp. seasoning salt\n" +
                 "1 tsp. garlic powder\n" +
                 "1 tsp. onion powder\n" +
                 "1/2 tsp. black pepper\n"+
                 "In a large bowl combine beef, salt, garlic powder, onion powder and black pepper just until combine\n" +
                 "Do not over-mix or burgers will be tough.\n" +
                 "Divide meat mixture into 6 equal portions\n" +
                 "Shape each into a tight ball. Use hands to flatten the ball into a disc\n" +
                 "Make it thinner in the center\n" +
                 "Smooth any cracks at the edges with the palm of your hand.\n" +
                 "Arrange patties on a large plate\n" +
                 "If they don’t fit in a single layer use plastic wrap, parchment paper or wax paper to separate the layers\n" +
                 " Cook immediately or cover and refrigerate until ready to cook (up to 12 hours)\n" +
                 "Heat skillet or grill to medium heat\n " +
                 "Cook burgers on the first side until a nice dark sear appears, 3-4 minutes\n" +
                 "Flip and cook on the second side until no longer pink inside, 2-6 minutes");
        }
        else if(y.equals("Cookies"))
        {
            Description.setText("Ingredients\n"+
                    "1 cup butter, softened\n" +
                    "1 cup white sugar\n" +
                    "1 cup packed brown sugar2 eggs\n" +
                    "365 Everyday Value® Large White Eggs\n" +
                    "2 teaspoons vanilla extract\n" +
                    "1 teaspoon baking soda\n" +
                    "2 teaspoons hot water\n" +
                    "1/2 teaspoon salt\n" +
                    "3 cups all-purpose flour\n" +
                    "2 cups semisweet chocolate chips\n" +
                    "1 cup chopped walnut\n"+
                    "Steps\n" +
                     "Preheat oven to 350 degrees F (175 degrees C)\n" +
                    "Cream together the butter, white sugar, and brown sugar until smooth\n" +
                    "Beat in the eggs one at a time, then stir in the vanilla\n" +
                    "Dissolve baking soda in hot water. Add to batter along with salt\n" +
                    "Stir in flour, chocolate chips, and nuts\n" +
                    "Drop by large spoonfuls onto ungreased pans.\n" +
                    "Bake for about 10 minutes in the preheated oven, or until edges are nicely browned.\n" +
                    "Footnotes\n" +
                    "Tip\n" +
                    "Aluminum foil can be used to keep food moist, cook it evenly, and make clean-up easier.");
        }
        else if(y.equals("Chicken Nuggets"))
        {
            Description.setText("Ingredients\n" +
                    "1/4 cup butter, melted\n" +
                    "1 cup panko (Japanese) bread crumbs\n" +
                    "1/2 cup grated Parmesan cheese\n" +
                    "1/2 teaspoon kosher salt\n" +
                    "1-1/2 pounds boneless skinless chicken breasts, cut into 1-inch cubes\n" +
                    "Steps\n" +
                    "Place butter in a shallow bowl\n" +
                    "Combine the bread crumbs, cheese and salt in another shallow bowl\n" +
                    "Dip chicken in butter, then roll in crumbs.\n" +
                    "Place in a single layer on two 15x10x1-in. baking pans\n" +
                    " Bake at 375° for 15-18 minutes or until no longer pink, turning once\n" +
                    "Serve with marinara sauce if desired\n");
        }

    }
}
