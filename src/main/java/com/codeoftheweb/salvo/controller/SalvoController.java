package com.codeoftheweb.salvo.controller;
import com.codeoftheweb.salvo.dto.*;
import com.codeoftheweb.salvo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SalvoController {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    GamePlayerRepository gamePlayerRepository;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    ShipRepository shipRepository;
    @Autowired
    SalvoRepository salvoRepository;

    @RequestMapping("/game_view/{ID}")
    public Map<String, Object> getGamePlayerView(@PathVariable long ID) {
        Game_ViewDTO dtoGame_View = new Game_ViewDTO();
        return dtoGame_View.makeGame_ViewDTO(gamePlayerRepository.getOne(ID));
    }

/*
    @RequestMapping("/player")
    public List<PlayerDTO> getPlayerAll() {
        return playerRepository.findAll()
                .stream().map(player -> new PlayerDTO(player))
                .collect(Collectors.toList());
    }
*/

    @RequestMapping("/player")
    public List<Map<String, Object>> getPlayerAll() {
        PlayerDTO dtoPlayer = new PlayerDTO();
        return playerRepository.findAll()
                .stream().map(player -> dtoPlayer.makePlayerDTO(player))
                .collect(Collectors.toList());
    }

    @RequestMapping("/ships")
    public List<Map<String, Object>> getShipAll() {
        ShipDTO dtoShip = new ShipDTO();
        return shipRepository.findAll()
                .stream().map(ship -> dtoShip.makeShipDTO(ship))
                .collect(Collectors.toList());
    }

    @RequestMapping("/games")
    public List<Map<String, Object>> getGameAll() {
        GameDTO dtoGame = new GameDTO();
        return gameRepository.findAll()
                .stream().map(game -> dtoGame.makeGameDTO(game))
                .collect(Collectors.toList());
    }

    @RequestMapping("/salvos")
    public List<Map<String, Object>> getSalvoAll() {
        SalvoDTO dtoSalvo = new SalvoDTO();
        return salvoRepository.findAll()
                .stream().map(salvo -> dtoSalvo.makeSalvoDTO(salvo))
                .collect(Collectors.toList());
    }


}