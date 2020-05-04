from sqlalchemy import create_engine
from plotly import graph_objects as go
from plotly.utils import PlotlyJSONEncoder as plenc
import plotly.express as px
import seaborn as sns
from plotly.subplots import make_subplots
import numpy as np
cm = sns.light_palette("red", as_cmap=True)
np.set_printoptions(precision=3)
import pandas as pd
import numpy as np
import json


engine = create_engine('postgresql://mbcwvfzqbqtgeq:f545b5bb7a2eacea60251cdc7ebb213ae6eb8ffab7f34506645a09f50214ea0a@ec2-54-247-118-139.eu-west-1.compute.amazonaws.com:5432/d3f0infj678s8u')

def get_analytic(user_id):
    
    user = pd.read_sql(f"SELECT * from user_dictionary_test where id={user_id}", engine)
    user_questions = pd.read_sql(f"SELECT * from questions_test where id_student={user_id}", engine)
    user_answer = pd.read_sql(f"SELECT at.id, at.message, at.carma_point, at.id_mentor, at.id_question, qt.hard_level, qt.category FROM answer_test at JOIN questions_test qt ON at.id_question = qt.id where at.id_mentor = {user_id}", engine)
    ans = {}
    
    if len(user_questions) > 0:
        user_questions['HARD'] = 0
        user_questions['MEDIUM'] = 0
        user_questions['EASY'] = 0
        for j in ["EASY", "MEDIUM", "HARD"]:
            for i in range(len(user_questions)):
                user_questions.at[i, j] =(int(user_questions.iloc[i]['hard_level'] == j))
        
        fig = go.Figure()
        fig.add_trace(go.Bar(x = user_questions.groupby(["category"]).count()["hard_level"].index, y = user_questions.groupby(["category"]).sum()["HARD"], name= "Сложные вопросы"))
        fig.add_trace(go.Bar(x = user_questions.groupby(["category"]).count()["hard_level"].index, y = user_questions.groupby(["category"]).sum()["MEDIUM"], name= "Средняя сложность"))
        fig.add_trace(go.Bar(x = user_questions.groupby(["category"]).count()["hard_level"].index, y = user_questions.groupby(["category"]).sum()["EASY"], name= "Простые вопросы"))

        fig.update_layout(title="Распределение по сложности вопросов", yaxis_title='Количество вопросов')
        
        redata = json.loads(json.dumps(fig.data, cls=plenc))

        ans['questions_level'] = redata
        
        fig = go.Figure()
        fig.add_trace(go.Pie(labels = user_questions.groupby(["category"]).count()["hard_level"].index, values = user_questions.groupby(["category"]).count()["hard_level"], hole=.4))

        fig.update_layout(title="Распределение вопросов по предметам", yaxis_title='Количество вопросов',
                         annotations = [
                                         {
                                            "font": {
                                               "size": 16
                                            },
                                            "showarrow": False,
                                            "text": str(user_questions.groupby(["category"]).count()["hard_level"].sum()) + " Вопросов",
                                            "x": 0.5,
                                            "y": 0.5
                                         }]
                             )
        
        ans['questions_category'] = json.loads(json.dumps(fig.data, cls=plenc))
        
        fig = go.Figure()
        fig.add_trace(go.Pie(labels = user_questions.groupby(["category"]).sum()["carma_point"].index, values = user_questions.groupby(["category"]).sum()["carma_point"], hole=.4))

        fig.update_layout(title="Распределение кармы по предметам", yaxis_title='Очки кармы',
                         annotations = [
                                         {
                                            "font": {
                                               "size": 16
                                            },
                                            "showarrow": False,
                                            "text": str(user_questions.groupby(["category"]).sum()["carma_point"].sum()) + " Кармы",
                                            "x": 0.5,
                                            "y": 0.5
                                         }]
                         )
        
        ans['questions_carma'] = json.loads(json.dumps(fig.data, cls=plenc))
        
    else:
        ans['questions_level'] = {}
        ans['questions_category'] = {}
        ans['questions_carma'] = {}
        
        
    if len(user_answer) > 0:
        user_answer['HARD'] = 0
        user_answer['MEDIUM'] = 0
        user_answer['EASY'] = 0
        for j in ["EASY", "MEDIUM", "HARD"]:
            for i in range(len(user_answer)):
                user_answer.at[i, j] = (int(user_answer.iloc[i]['hard_level'] == j))
                
        
        fig = go.Figure()
        fig.add_trace(go.Bar(x = user_answer.groupby(["category"]).count()["hard_level"].index, y = user_answer.groupby(["category"]).sum()["HARD"], name= "Сложные вопросы"))
        fig.add_trace(go.Bar(x = user_answer.groupby(["category"]).count()["hard_level"].index, y = user_answer.groupby(["category"]).sum()["MEDIUM"], name= "Средняя сложность"))
        fig.add_trace(go.Bar(x = user_answer.groupby(["category"]).count()["hard_level"].index, y = user_answer.groupby(["category"]).sum()["EASY"], name= "Простые вопросы"))

        fig.update_layout(title="Распределение по сложности вопросов", yaxis_title='Количество вопросов')
        
        ans['answer_level'] = json.loads(json.dumps(fig.data, cls=plenc))
        
        fig = go.Figure()
        fig.add_trace(go.Pie(labels = user_answer.groupby(["category"]).count()["hard_level"].index, values = user_answer.groupby(["category"]).count()["hard_level"], hole=.4))

        fig.update_layout(title="Распределение вопросов по предметам", yaxis_title='Количество вопросов',
                         annotations = [
                                         {
                                            "font": {
                                               "size": 16
                                            },
                                            "showarrow": False,
                                            "text": str(user_answer.groupby(["category"]).count()["hard_level"].sum()) + " Вопросов",
                                            "x": 0.5,
                                            "y": 0.5
                                         }]
                             )
        
        ans['answer_category'] = json.loads(json.dumps(fig.data, cls=plenc))
        
        fig = go.Figure()
        fig.add_trace(go.Pie(labels = user_answer.groupby(["category"]).sum()["carma_point"].index, values = user_answer.groupby(["category"]).sum()["carma_point"], hole=.4))

        fig.update_layout(title="Распределение кармы по предметам", yaxis_title='Очки кармы',
                         annotations = [
                                         {
                                            "font": {
                                               "size": 16
                                            },
                                            "showarrow": False,
                                            "text": str(user_answer.groupby(["category"]).sum()["carma_point"].sum()) + " Кармы",
                                            "x": 0.5,
                                            "y": 0.5
                                         }]
                         )
        
        ans['answer_carma'] = json.loads(json.dumps(fig.data, cls=plenc))
        
    else:
        ans['answer_level'] = {}
        ans['answer_category'] = {}
        ans['answer_carma'] = {}
    
    return json.dumps(ans)