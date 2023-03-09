package ru.alekseyruban.clicker_mine.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import ru.alekseyruban.clicker_mine.R;
import ru.alekseyruban.clicker_mine.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    int budget = 5000;

    Mine mine1 = new Mine(1);
    Mine mine2 = new Mine(2);
    Mine mine3 = new Mine(3);

    Elevator elevator = new Elevator();
    Transporter transporter = new Transporter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding .inflate(getLayoutInflater());

        binding.budget.setText(budget + "$");

        binding.transporter.total.setText("0$");
        binding.transporter.upgradeCoast.setText("200$");

        binding.elevator.position.setText("0 position");
        binding.elevator.total.setText("0$");
        binding.elevator.upgradeCoast.setText("200$");

        binding.mine1.name.setText("Mine № 1");
        binding.mine1.perSecond.setText("0 p/cl");
        binding.mine1.level.setText("Level 0");
        binding.mine1.total.setText("0$");
        binding.mine1.upgradeCoast.setText("100$");

        binding.mine2.name.setText("Mine № 2");
        binding.mine2.perSecond.setText("0 p/cl");
        binding.mine2.level.setText("Level 0");
        binding.mine2.total.setText("0$");
        binding.mine2.upgradeCoast.setText("1000$");

        binding.mine3.name.setText("Mine № 3");
        binding.mine3.perSecond.setText("0 p/cl");
        binding.mine3.level.setText("Level 0");
        binding.mine3.total.setText("0$");
        binding.mine3.upgradeCoast.setText("10k $");



        binding.mine1.click.setOnClickListener(view -> {
            clickMine(1);
        });
        binding.mine2.click.setOnClickListener(view -> {
            clickMine(2);
        });
        binding.mine3.click.setOnClickListener(view -> {
            clickMine(3);
        });

        binding.mine1.upgrade.setOnClickListener(view -> {
            upgradeMine(1);
        });
        binding.mine2.upgrade.setOnClickListener(view -> {
            upgradeMine(2);
        });
        binding.mine3.upgrade.setOnClickListener(view -> {
            upgradeMine(3);
        });




        binding.elevator.click.setOnClickListener(view -> {
            clickElevator();
        });
        binding.elevator.upgrade.setOnClickListener(view -> {
            upgradeElevator();
        });




        binding.transporter.click.setOnClickListener(view -> {
            clickTransporter();
        });
        binding.transporter.upgrade.setOnClickListener(view -> {
            upgradeTransporter();
        });


        setContentView(binding.getRoot());
    }

    void upgradeMine(int number) {
        switch (number) {
            case 1:
                if (mine1.getUpgradeCoast() > budget) {
                    Toast toast = Toast.makeText(this, "Low money",Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    budget -= mine1.getUpgradeCoast();
                    mine1.upgrade();
                    binding.budget.setText(budget + "$");
                    binding.mine1.upgradeCoast.setText(mine1.getUpgradeCoast() + "$");
                    binding.mine1.level.setText("Level " + mine1.getLevel());
                    binding.mine1.perSecond.setText(mine1.getGoldPerS() + " p/cl");
                }
                break;
            case 2:
                if (mine2.getUpgradeCoast() > budget) {
                    Toast toast = Toast.makeText(this, "Low money",Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    budget -= mine2.getUpgradeCoast();
                    mine2.upgrade();
                    binding.budget.setText(budget + "$");
                    binding.mine2.upgradeCoast.setText(mine2.getUpgradeCoast() + "$");
                    binding.mine2.level.setText("Level " + mine2.getLevel());
                    binding.mine2.perSecond.setText(mine2.getGoldPerS() + " p/cl");
                }
                break;
            case 3:
                if (mine3.getUpgradeCoast() > budget) {
                    Toast toast = Toast.makeText(this, "Low money",Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    budget -= mine3.getUpgradeCoast();
                    mine3.upgrade();
                    binding.budget.setText(budget + "$");
                    binding.mine3.upgradeCoast.setText(mine3.getUpgradeCoast() + "$");
                    binding.mine3.level.setText("Level " + mine3.getLevel());
                    binding.mine3.perSecond.setText(mine3.getGoldPerS() + " p/cl");
                }
                break;
        }
    }

    void clickMine(int number) {
        switch (number) {
            case 1:
                if (mine1.getLevel() == 0) {
                    Toast toast = Toast.makeText(this, "Should upgrade",Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    mine1.click();
                    binding.mine1.total.setText(mine1.getGoldSaved() + "$");
                }
                break;
            case 2:
                if (mine2.getLevel() == 0) {
                    Toast toast = Toast.makeText(this, "Should upgrade",Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    mine2.click();
                    binding.mine2.total.setText(mine2.getGoldSaved() + "$");
                }
                break;
            case 3:
                if (mine3.getLevel() == 0) {
                    Toast toast = Toast.makeText(this, "Should upgrade",Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    mine3.click();
                    binding.mine3.total.setText(mine3.getGoldSaved() + "$");
                }
                break;
        }
    }

    void upgradeElevator() {
        if (elevator.getUpgradeCoast() > budget) {
            Toast toast = Toast.makeText(this, "Low money",Toast.LENGTH_LONG);
            toast.show();
        } else {
            budget -= elevator.getUpgradeCoast();
            elevator.upgrade();
            binding.elevator.level.setText("Level " + elevator.getLevel());
            binding.elevator.upgradeCoast.setText(elevator.getUpgradeCoast() + "$");
            binding.budget.setText(budget + "$");
        }
    }

    void clickElevator() {
        elevator.setPosition((elevator.getPosition() + 1) % 4);
        binding.elevator.position.setText(elevator.getPosition() + " position");

        switch (elevator.getPosition()) {
            case 0:
                if (transporter.getGoldMaxSize() - transporter.getGoldSaved() >= elevator.getGoldSaved()) {
                    transporter.setGoldSaved(transporter.getGoldSaved() + elevator.getGoldSaved());
                    elevator.setGoldSaved(0);
                } else if (transporter.getGoldSaved() == transporter.getGoldMaxSize()) {
                    break;
                } else {
                    elevator.setGoldSaved(elevator.getGoldSaved() - (transporter.getGoldMaxSize() - transporter.getGoldSaved()));
                    transporter.setGoldSaved(transporter.getGoldMaxSize());
                }
                binding.elevator.total.setText(elevator.getGoldSaved() + "$");
                binding.transporter.total.setText(transporter.getGoldSaved() + "$");
                break;
            case 1:
                if (elevator.getGoldMaxSize() - elevator.getGoldSaved() > mine1.getGoldSaved()) {
                    elevator.setGoldSaved(elevator.getGoldSaved() + mine1.getGoldSaved());
                    mine1.setGoldSaved(0);
                } else {
                    mine1.setGoldSaved(mine1.getGoldSaved() - (elevator.getGoldMaxSize() - elevator.getGoldSaved()));
                    elevator.setGoldSaved(elevator.getGoldMaxSize());
                }
                binding.elevator.total.setText(elevator.getGoldSaved() + "$");
                binding.mine1.total.setText(mine1.getGoldSaved() + "$");

                break;
            case 2:
                if (elevator.getGoldMaxSize() - elevator.getGoldSaved() > mine2.getGoldSaved()) {
                    elevator.setGoldSaved(elevator.getGoldSaved() + mine2.getGoldSaved());
                    mine2.setGoldSaved(0);
                } else {
                    mine2.setGoldSaved(mine2.getGoldSaved() - (elevator.getGoldMaxSize() - elevator.getGoldSaved()));
                    elevator.setGoldSaved(elevator.getGoldMaxSize());
                }
                binding.elevator.total.setText(elevator.getGoldSaved() + "$");
                binding.mine2.total.setText(mine2.getGoldSaved() + "$");

                break;
            case 3:
                if (elevator.getGoldMaxSize() - elevator.getGoldSaved() > mine3.getGoldSaved()) {
                    elevator.setGoldSaved(elevator.getGoldSaved() + mine3.getGoldSaved());
                    mine3.setGoldSaved(0);
                } else {
                    mine3.setGoldSaved(mine3.getGoldSaved() - (elevator.getGoldMaxSize() - elevator.getGoldSaved()));
                    elevator.setGoldSaved(elevator.getGoldMaxSize());
                }
                binding.elevator.total.setText(elevator.getGoldSaved() + "$");
                binding.mine3.total.setText(mine3.getGoldSaved() + "$");

                break;
        }
    }

    void upgradeTransporter() {
        if (transporter.getUpgradeCoast() > budget) {
            Toast toast = Toast.makeText(this, "Low money",Toast.LENGTH_LONG);
            toast.show();
        } else {
            budget -= transporter.getUpgradeCoast();
            transporter.upgrade();
            binding.transporter.level.setText("Level " + transporter.getLevel());
            binding.transporter.upgradeCoast.setText(transporter.getUpgradeCoast() + "$");
            binding.budget.setText(budget + "$");
        }
    }

    void clickTransporter() {
        budget += transporter.getGoldSaved();
        transporter.setGoldSaved(0);
        binding.transporter.total.setText(0 + "$");
        binding.budget.setText(budget + "$");
    }
}