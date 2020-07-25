package com.dance.h2ostudioz.Fragments;

import android.graphics.Movie;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dance.h2ostudioz.Adapters.ExpandableListAdapter;
import com.dance.h2ostudioz.Adapters.MovieCategoryAdapter;
import com.dance.h2ostudioz.Adapters.ParentListItem;
import com.dance.h2ostudioz.Models.Day;
import com.dance.h2ostudioz.Models.DayOfTheWeek;
import com.dance.h2ostudioz.Models.MovieCategory;
import com.dance.h2ostudioz.Models.Movies;
import com.dance.h2ostudioz.Models.Schedule;
import com.dance.h2ostudioz.R;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ScheduleFragment extends Fragment {

    private List<Schedule> scheduleList = new ArrayList<>();
    private RecyclerView recyclerView;
    List<String> listDataHeader;
    HashMap<String, String> listDataChild;

    String json = "[\n" +
            "    {\n" +
            "        \"days\": [\n" +
            "            {\n" +
            "                \"Monday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                        \" 7:30 - 8:30 \",\n" +
            "                        \" 8:30 - 9:30 \"\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.980Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.980Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5efd\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Tuesday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5efe\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Wednesday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                        \" 7:30 - 8:30 \",\n" +
            "                        \" 8:30 - 9:30 \"\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5eff\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Thursday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.983Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.983Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5f00\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Friday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"id\": \"587f92cd5272c26662ee5f01\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Saturday\": {\n" +
            "                    \"morning\": [\n" +
            "                        \" 9:30 - 10:30 \",\n" +
            "                        \" 10:30 - 11:30 \",\n" +
            "                        \" 11:30 - 12:30 \"\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"id\": \"587f92cd5272c26662ee5f01\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Sunday\": {\n" +
            "                    \"morning\": [\n" +
            "                        \" 10:30 - 11:30 \",\n" +
            "                        \" 11:30 - 12:30 \",\n" +
            "                        \" 12:30 - 1:30 \"\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"id\": \"587f92cd5272c26662ee5f01\"\n" +
            "                }\n" +
            "            }],\n" +
            "        \"danceForm\": \"Bollywood / FreeStyle / Hip-hop\",\n" +
            "        \"danceFormKey\": \"bollywood\",\n" +
            "        \"desc\": \"Take your waves, footwork, and grooves to a whole new level by focusing on your musicality and timing. You can even combine them with other styles like jump style, tecktonic, hip hop, etc. In bollywood/FreeStyle/Hip-hop class, you will learn how to put all these moves together!!\",\n" +
            "        \"createdAt\": \"2017-01-18T16:07:41.016Z\",\n" +
            "        \"updatedAt\": \"2017-01-18T16:07:41.016Z\",\n" +
            "        \"id\": \"587f92cd5272c26662ee5f02\"\n" +
            "\n" +
            "    },\n" +
            "    {\n" +
            "        \"days\": [\n" +
            "            {\n" +
            "                \"Monday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.980Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.980Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5efd\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Tuesday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5efe\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Wednesday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5eff\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Thursday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.983Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.983Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5f00\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Friday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"id\": \"587f92cd5272c26662ee5f01\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Saturday\": {\n" +
            "                    \"morning\": [\n" +
            "\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                        \"4:00 - 5:30\"\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"id\": \"587f92cd5272c26662ee5f01\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Sunday\": {\n" +
            "                    \"morning\": [\n" +
            "                        \"9:00 - 10:30\"\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"id\": \"587f92cd5272c26662ee5f01\"\n" +
            "                }\n" +
            "            }],\n" +
            "        \"danceForm\": \"Kids Freestyle\",\n" +
            "        \"danceFormKey\": \"kids_freestyle\",\n" +
            "        \"desc\": \"Let your kids move their feet in H2O Studioz !!\",\n" +
            "        \"id\": \"587f92cd5272c26662ee5f02\"\n" +
            "\n" +
            "    },\n" +
            "    {\n" +
            "        \"days\": [\n" +
            "            {\n" +
            "                \"Monday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.980Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.980Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5efd\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Tuesday\": {\n" +
            "                    \"morning\": [\n" +
            "                        \n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5efe\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Wednesday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5eff\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Thursday\": {\n" +
            "                    \"morning\": [\n" +
            "                       \n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.983Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.983Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5f00\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Friday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [ \t\n" +
            "                    \t\"7:30 - 9:00\"\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"id\": \"587f92cd5272c26662ee5f01\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Saturday\": {\n" +
            "                    \"morning\": [\n" +
            "\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"id\": \"587f92cd5272c26662ee5f01\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Sunday\": {\n" +
            "                    \"morning\": [\n" +
            "\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"id\": \"587f92cd5272c26662ee5f01\"\n" +
            "                }\n" +
            "            }],\n" +
            "        \"danceForm\": \"Contemporary\",\n" +
            "        \"danceFormKey\": \"contemporary\",\n" +
            "        \"desc\": \"Feel your soul in this form of dance !!\",\n" +
            "        \"id\": \"587f92cd5272c26662ee5f02\"\n" +
            "\n" +
            "    },\n" +
            "    {\n" +
            "        \"days\": [\n" +
            "            {\n" +
            "                \"Monday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.980Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.980Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5efd\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Tuesday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5efe\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Wednesday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5eff\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Thursday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.983Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.983Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5f00\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Friday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"id\": \"587f92cd5272c26662ee5f01\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Saturday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                        \"1:30 - 3:30\"\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"id\": \"587f92cd5272c26662ee5f01\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Sunday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                        \n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"id\": \"587f92cd5272c26662ee5f01\"\n" +
            "                }\n" +
            "            }],\n" +
            "        \"danceForm\": \"Salsa\",\n" +
            "        \"danceFormKey\": \"salsa\",\n" +
            "        \"desc\": \"Learn how to groove with Salsa !!\",\n" +
            "        \"id\": \"587f92cd5272c26662ee5f02\"\n" +
            "\n" +
            "    },\n" +
            "    {\n" +
            "        \"days\": [\n" +
            "            {\n" +
            "                \"Monday\": {\n" +
            "                    \"morning\": [\n" +
            "                        \"7:15-8:15\"\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                        \"6:30 - 7:30\"\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.980Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.980Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5efd\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Tuesday\": {\n" +
            "                    \"morning\": [\n" +
            "                        \" 8:00 - 9:00 \"\n" +
            "                        \n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                        \"7:30 - 8:30\"\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5efe\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Wednesday\": {\n" +
            "                    \"morning\": [\n" +
            "                        \"7:15-8:15\"\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                        \"6:30 - 7:30\"\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5eff\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Thursday\": {\n" +
            "                    \"morning\": [\n" +
            "                        \" 8:00 - 9:00 \"\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                        \"7:30 - 8:30\"\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.983Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.983Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5f00\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Friday\": {\n" +
            "                    \"morning\": [\n" +
            "                        \"7:15-8:15\"\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                        \"6:30 - 7:30\"\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"id\": \"587f92cd5272c26662ee5f01\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Saturday\": {\n" +
            "                    \"morning\": [\n" +
            "                        \"8:00 - 9:00\"\n" +
            "\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"id\": \"587f92cd5272c26662ee5f01\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Sunday\": {\n" +
            "                    \"morning\": [\n" +
            "                        \"8:00 - 9:00\"\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"id\": \"587f92cd5272c26662ee5f01\"\n" +
            "                }\n" +
            "            }],\n" +
            "        \"danceForm\": \"Zumba\",\n" +
            "        \"danceFormKey\": \"zumba\",\n" +
            "        \"desc\": \"A total workout, combining all elements of fitness – cardio, muscle conditioning, balance and flexibility, boosted energy and a serious dose of awesome each time you leave class.\",\n" +
            "        \"id\": \"587f92cd5272c26662ee5f02\"\n" +
            "\n" +
            "    },\n" +
            "    {\n" +
            "        \"days\": [],\n" +
            "        \"danceForm\": \"Yoga\",\n" +
            "        \"danceFormKey\": \"yoga\",\n" +
            "        \"desc\": \"Learn to live balanced and healthy life with Yoga !!\",\n" +
            "        \"id\": \"587f92cd5272c26662ee5f02\"\n" +
            "\n" +
            "    },\n" +
            "    {\n" +
            "        \"days\": [\n" +
            "            ],\n" +
            "        \"danceForm\": \"Masala Bhangra\",\n" +
            "        \"danceFormKey\": \"masala_bhangra\",\n" +
            "        \"desc\": \"Masala Bhangra is an Indian cardio fitness program designed for people of all ages and levels who love to stay physically active and loose weight.\",\n" +
            "        \"id\": \"587f92cd5272c26662ee5f02\"\n" +
            "\n" +
            "    },\n" +
            "    {\n" +
            "        \"days\": [\n" +
            "            ],\n" +
            "        \"danceForm\": \"Aqua Zumba\",\n" +
            "        \"danceFormKey\": \"aqua_zumba\",\n" +
            "        \"desc\": \"Those looking to make a splash by adding a low-impact, high-energy aquatic exercise to their fitness routine.\",\n" +
            "        \"id\": \"587f92cd5272c26662ee5f02\"\n" +
            "\n" +
            "    },\n" +
            "    {\n" +
            "        \"days\": [\n" +
            "            {\n" +
            "                \"Monday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.980Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.980Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5efd\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Tuesday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5efe\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Wednesday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.982Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5eff\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Thursday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:40.983Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:40.983Z\",\n" +
            "                    \"id\": \"587f92cc5272c26662ee5f00\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Friday\": {\n" +
            "                    \"morning\": [\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"id\": \"587f92cd5272c26662ee5f01\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Saturday\": {\n" +
            "                    \"morning\": [\n" +
            "\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "                        \"3:00 - 4:00\"\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"id\": \"587f92cd5272c26662ee5f01\"\n" +
            "                }\n" +
            "            }, {\n" +
            "                \"Sunday\": {\n" +
            "                    \"morning\": [\n" +
            "                        \"10:30 - 11:30\"\n" +
            "                    ],\n" +
            "                    \"evening\": [\n" +
            "\n" +
            "                    ],\n" +
            "                    \"createdAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"updatedAt\": \"2017-01-18T16:07:41.010Z\",\n" +
            "                    \"id\": \"587f92cd5272c26662ee5f01\"\n" +
            "                }\n" +
            "            }],\n" +
            "        \"danceForm\": \"Carnatic Music\",\n" +
            "        \"danceFormKey\": \"music\",\n" +
            "        \"desc\": \"Music is the strongest form of Magic. Where words fail, music speaks. Come and find your soul with Carnatic music !!\",\n" +
            "        \"id\": \"587f92cd5272c26662ee5f02\"\n" +
            "\n" +
            "    },\n" +
            "    {\n" +
            "        \"days\": [],\n" +
            "        \"danceForm\": \"Corporate Events\",\n" +
            "        \"danceFormKey\": \"corporate_events\",\n" +
            "        \"desc\": \"For more details, contact H2O STUDIOZ !!!\",\n" +
            "        \"id\": \"587f92cd5272c26662ee5f02\"\n" +
            "\n" +
            "    },\n" +
            "    {\n" +
            "        \"days\": [\n" +
            "            ],\n" +
            "        \"danceForm\": \"Wedding Choreos\",\n" +
            "        \"danceFormKey\": \"wedding_choreos\",\n" +
            "        \"desc\": \"For more details, contact H2O STUDIOZ !!!\",\n" +
            "        \"id\": \"587f92cd5272c26662ee5f02\"\n" +
            "\n" +
            "    },\n" +
            "    {\n" +
            "        \"days\": [\n" +
            "            ],\n" +
            "        \"danceForm\": \"Zumba Workshops\",\n" +
            "        \"danceFormKey\": \"zumba_workshops\",\n" +
            "        \"desc\": \"For more details, contact H2O STUDIOZ !!!\",\n" +
            "        \"id\": \"587f92cd5272c26662ee5f02\"\n" +
            "\n" +
            "    },\n" +
            "    {\n" +
            "        \"days\": [],\n" +
            "        \"danceForm\": \"Dance Performances/Flashmobs\",\n" +
            "        \"danceFormKey\": \"dance_performances\",\n" +
            "        \"desc\": \"For more details, contact H2O STUDIOZ !!!\",\n" +
            "        \"id\": \"587f92cd5272c26662ee5f02\"\n" +
            "\n" +
            "    }\n" +
            "    ]";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        List<Schedule> scheduleList = new ArrayList<>();

        try {
            JSONArray jArray = new JSONArray(json);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject object = jArray.getJSONObject(i);
                Schedule schedule = new Schedule();
                schedule.setDanceForm(object.optString("danceForm"));
                schedule.setDanceFormKey(object.optString("danceFormKey"));
                schedule.setDesc(object.optString("desc"));
                JSONArray daysArray = object.optJSONArray("days");
                Day day = new Day();
                List<DayOfTheWeek> dayOfTheWeeks = new ArrayList<>();
                day.setDayOfTheWeeks(dayOfTheWeeks);
                for (int j = 0; j < daysArray.length(); j++) {
                    JSONObject jsonObject = daysArray.getJSONObject(j);
                    String key = jsonObject.keys().next();
                    DayOfTheWeek dayOfTheWeek = null;
                    Gson gson = new Gson();
                    JSONObject daysObject = jsonObject.getJSONObject(key);
                    dayOfTheWeek = gson.fromJson(daysObject + "", DayOfTheWeek.class);
                    dayOfTheWeek.setDayName(key);
                    dayOfTheWeeks.add(dayOfTheWeek);

                }
                schedule.setDays(day);
                scheduleList.add(schedule);
            }

        } catch (JSONException e) {
            Log.e("Error", "Error while parsing object");
        }

        List<ParentListItem> data = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));


        for (Schedule schedule : scheduleList) {

//            data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, schedule.getDanceForm()));
//            data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD_DESC, schedule.getDesc()));
            List<Movies> movies = new ArrayList<>();

            Movies movies1 = new Movies();
            movies1.setDescription(schedule.getDesc());
            movies1.setCHILD_TYPE(Movies.DESC_CHILD);
            movies.add(movies1);
            if(schedule.getDays().getDayOfTheWeeks().size() > 0) {
                Movies movies3 = new Movies();
                movies3.setCHILD_TYPE(Movies.DOW);
                movies.add(movies3);
            }
            for (DayOfTheWeek dayOfTheWeek : schedule.getDays().getDayOfTheWeeks()) {
                Movies movies2 = new Movies();
                if(dayOfTheWeek.getEvening().size() >0 ||   dayOfTheWeek.getMorning().size() > 0) {
                    movies2.setDayOfTheWeek(dayOfTheWeek);
                    movies2.setCHILD_TYPE(Movies.DOW_CHILD);
                    movies.add(movies2);
                }

            }

            MovieCategory movieCategory = new MovieCategory(schedule.getDanceForm(),movies);

            data.add(movieCategory);
        }

        recyclerView.setAdapter(new MovieCategoryAdapter(getActivity(),data));

//        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                // TODO Handle item click
//            }
//        }));
        return view;

    }

}
