<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>UEFA</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <style>
        .table-responsive {
            margin: 0 auto;
            max-width: 80%;
        }
        th {
            background-color: red;
            color: white;
        }
        h4 { 
            text-align: center; 
        }
        
    </style>
</head>
<body>

<br>
<div class="col-md-12">
    <h4>UEFA</h4>
    <div class="table-responsive">
        <table class="table table-hover table-striped nova-stats-table">
            <thead>
                <tr>
                    <th>Equipe</th>
                    <th>MJ</th>
                    <th>V</th>
                    <th>VPrl</th>
                    <th>DPrl</th>
                    <th>D</th>
                    <th>Pts.</th>
                    <th>%</th>
                    <th>BP</th>
                    <th>BC</th>
                    <th>Pen.</th>
                    <th>Domicile</th>
                    <th>Extérieur</th>
                </tr>
            </thead>
            <tbody>
                <!-- Inclure ici les lignes pour chaque équipe -->
                <!-- Exemple pour Caen -->
                <tr class="maincolor">
                    <td><a href="teamplayerstats.html?teamid=393364&seasonid=20146"> Caen</a></td>
                    <td>3</td>
                    <td>2</td>
                    <td>1</td>
                    <td>0</td>
                    <td>0</td>
                    <td class="highlight-points">8</td>
                    <td>.889</td>
                    <td>11</td>
                    <td>3</td>
                    <td>30</td>
                    <td>2-0-0-0</td>
                    <td>0-1-0-0</td>
                </tr>
                <!-- Exemple pour Nantes -->
                <tr class="light">
                    <td><a href="teamplayerstats.html?teamid=454167&seasonid=20146"> Nantes</a></td>
                    <td>3</td>
                    <td>2</td>
                    <td>1</td>
                    <td>0</td>
                    <td>0</td>
                    <td class="highlight-points">8</td>
                    <td>.889</td>
                    <td>13</td>
                    <td>9</td>
                    <td>92</td>
                    <td>1-0-0-0</td>
                    <td>1-1-0-0</td>
                </tr>
                
                
                
                <!-- Mont-Blanc -->
<tr class="maincolor">
    <td><a href="teamplayerstats.html?teamid=454164&seasonid=20146"> Mont-Blanc</a></td>
    <td>3</td>
    <td>2</td>
    <td>1</td>
    <td>0</td>
    <td>0</td>
    <td class="highlight-points">8</td>
    <td>.889</td>
    <td>14</td>
    <td>10</td>
    <td>26</td>
    <td>0-1-0-0</td>
    <td>2-0-0-0</td>
</tr>
<!-- Cergy-Pontoise -->
<tr class="light">
    <td><a href="teamplayerstats.html?teamid=508008&seasonid=20146"> Cergy-Pontoise</a></td>
    <td>4</td>
    <td>2</td>
    <td>0</td>
    <td>0</td>
    <td>2</td>
    <td class="highlight-points">6</td>
    <td>.500</td>
    <td>14</td>
    <td>13</td>
    <td>98</td>
    <td>2-0-0-0</td>
    <td>0-0-0-2</td>
</tr>
<!-- Dunkerque -->
<tr class="maincolor">
    <td><a href="teamplayerstats.html?teamid=454162&seasonid=20146"> Dunkerque</a></td>
    <td>4</td>
    <td>2</td>
    <td>0</td>
    <td>0</td>
    <td>2</td>
    <td class="highlight-points">6</td>
    <td>.500</td>
    <td>13</td>
    <td>14</td>
    <td>62</td>
    <td>2-0-0-0</td>
    <td>0-0-0-2</td>
</tr>
<!-- Brest -->
<tr class="light">
    <td><a href="teamplayerstats.html?teamid=453147&seasonid=20146"> Brest</a></td>
    <td>3</td>
    <td>0</td>
    <td>0</td>
    <td>1</td>
    <td>2</td>
    <td class="highlight-points">1</td>
    <td>.111</td>
    <td>10</td>
    <td>14</td>
    <td>26</td>
    <td>0-0-0-2</td>
    <td>0-0-1-0</td>
</tr>
<!-- Neuilly-sur-Marne -->
<tr class="maincolor">
    <td><a href="teamplayerstats.html?teamid=454168&seasonid=20146"> Neuilly-sur-Marne</a></td>
    <td>3</td>
    <td>0</td>
    <td>0</td>
    <td>1</td>
    <td>2</td>
    <td class="highlight-points">1</td>
    <td>.111</td>
    <td>9</td>
    <td>13</td>
    <td>118</td>
    <td>0-0-1-1</td>
    <td>0-0-0-1</td>
</tr>
<!-- Tours -->
<tr class="light">
    <td><a href="teamplayerstats.html?teamid=508005&seasonid=20146"> Tours</a></td>
    <td>3</td>
    <td>0</td>
    <td>0</td>
    <td>1</td>
    <td>2</td>
    <td class="highlight-points">1</td>
    <td>.111</td>
    <td>3</td>
    <td>11</td>
    <td>66</td>
    <td>0-0-1-0</td>
    <td>0-0-0-2</td>
</tr>
                
                <!-- Autres lignes pour les autres équipes -->
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
