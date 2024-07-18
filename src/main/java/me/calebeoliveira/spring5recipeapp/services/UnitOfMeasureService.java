package me.calebeoliveira.spring5recipeapp.services;

import me.calebeoliveira.spring5recipeapp.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}
