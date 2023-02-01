
# Plant Radiation Simulation( using C++)

**Refer to the documentation for detailed information.**

## Task

Different kinds of plants live on a planet. If the nutrient of a plant runs out (its nutrient level becomes zero), the plant wastes away. There are three kinds of radiation on the planet: alpha, delta, no radiation. The different species of plants react to radiation differently. The reaction involves a change in the nutrient level of the plant and the radiation the next day. The radiation of the next day will be alpha radiation if the sum of the demand for alpha radiation over all plants is greater than the sum of the demand for delta radiation by at least three. If the demand for delta radiation is greater by at least three than the demand for alpha radiation, the radiation will be delta. If the difference is less than three, there will be no radiation. There is no radiation the first day.

Each plant has a name (string), a nutrient level (int), and a boolean that denotes whether it's alive. The plant species are wombleroot, wittentoot and woreroot. The different plant species react to the different radiations as follows. The level of nutrients changes first. After that, the plant can influence the radiation of the next day if it's still alive.

The task is simulate the ecosystem of plants and give the name of the strongest plant which is still alive after n days. Print all the data of the plants and the level of radiation on each day.

